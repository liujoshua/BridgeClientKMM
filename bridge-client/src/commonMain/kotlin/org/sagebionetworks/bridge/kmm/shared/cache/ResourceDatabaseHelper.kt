package org.sagebionetworks.bridge.kmm.shared.cache

import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow

class ResourceDatabaseHelper(sqlDriver: SqlDriver) {
    internal val database = BridgeResourceDatabase(
        sqlDriver,
        Resource.Adapter(EnumColumnAdapter(), EnumColumnAdapter())
    )
    private val dbQuery = database.bridgeResourceDatabaseQueries


    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllResources()
        }
    }

    internal fun getResourceAsFlow(id: String, type: ResourceType, studyId: String): Flow<Resource?> {
        return dbQuery.selectResourceById(id, type, studyId).asFlow().mapToOneOrNull()
    }

    internal fun getResource(id: String, type: ResourceType, studyId: String): Resource? {
        return dbQuery.selectResourceById(id, type, studyId).executeAsOneOrNull()
    }

    internal fun removeResource(id: String, type: ResourceType, studyId: String) {
        dbQuery.removeResourceById(id, type, studyId)
    }

    internal fun insertUpdateResource(resource: Resource) {
        dbQuery.insertUpdateResource(
            identifier = resource.identifier,
            secondaryId = resource.secondaryId,
            type = resource.type,
            json = resource.json,
            lastUpdate = resource.lastUpdate,
            status = resource.status,
            studyId = resource.studyId,
            needSave = resource.needSave
        )
    }

    internal fun getResourcesByIds(ids: List<String>, type: ResourceType, studyId: String) : List<Resource> {
        return dbQuery.selectResourceByIds(ids, type, studyId).executeAsList()
    }

    internal fun getResourcesNeedSave(type: ResourceType, studyId: String) : List<Resource> {
        return dbQuery.selectResourceNeedSave(type, studyId).executeAsList()
    }

    internal fun getResourcesAsFlow(type: ResourceType, studyId: String): Flow<List<Resource>> {
        return dbQuery.selectAllResourcesByType(type, studyId).asFlow().mapToList()
    }

    internal fun getResources(type: ResourceType, studyId: String): List<Resource> {
        return dbQuery.selectAllResourcesByType(type, studyId).executeAsList()
    }

    internal fun removeAllResources(type: ResourceType, studyId: String) {
        dbQuery.removeAllResourcesByType(type, studyId)
    }

    /**
     * Remove all resources of the specified type and replace them with the specified list.
     * This is done as a single transaction.
     */
    internal fun removeAndUpdateResources(type: ResourceType, resources: List<Resource>, studyId: String) {
        database.transaction {
            dbQuery.removeAllResourcesByType(type, studyId)
            for(r in resources) {
                insertUpdateResource(r)
            }

        }
    }

    companion object {

        /**
         * For caching resources that are not specific to an individual study.
         */
        const val APP_WIDE_STUDY_ID = "AppWideStudyId"

        /**
         * For caching resources that don't have/need a secondary identifier.
         */
        const val DEFAULT_SECONDARY_ID = "DefaultSecondaryId"

    }

}