package org.sagebionetworks.bridge.kmm.shared.cache

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.sagebionetworks.bridge.kmm.shared.models.AssessmentConfig
import kotlin.reflect.KClass

enum class ResourceType() {
    ASSESSMENT_CONFIG,
    APP_CONFIG,
    UPLOAD_SESSION,
    FILE_UPLOAD,
    USER_SESSION_INFO,
    TIMELINE,
    ACTIVITY_EVENTS_LIST,
    ADHERENCE_RECORD,
}

enum class ResourceStatus {
    SUCCESS, //Successfully loaded from Bridge
    PENDING, //Remote web call is in process
    RETRY,   //Remote web call failed due to a transient error and could be retried
    FAILED   //Remote web call failed
}

sealed class ResourceResult<out T : Any> {
    data class Success<out T : Any>(val data: T, val status: ResourceStatus) : ResourceResult<T>()
    //TODO: Failed reason -nbrown 12/4/20
    data class Failed(val status: ResourceStatus) : ResourceResult<Nothing>()
    object InProgress : ResourceResult<Nothing>()
}

inline fun <reified T: Any> Resource.loadResource(): T? {
    json?.let {
        val jsonCoder = Json {ignoreUnknownKeys = true }
        return jsonCoder.decodeFromString(it)
    } ?: return null
}