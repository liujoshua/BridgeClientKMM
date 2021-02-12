/**
* Bridge Server API
* No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
*
* OpenAPI spec version: 0.16.25
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package org.sagebionetworks.bridge.mpp.network.generated.models

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

/**
 * **Important: Headers of the same values must be used when doing the upload against the pre-signed URL.** 
 * @param name File name
 * @param contentLength The size of the object in bytes. A standard HTTP header. For more information, go to [http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.13](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.13) 
 * @param contentMd5 The base64-encoded, 128-bit MD5 digest of the object body.
 * @param contentType A standard MIME type. For more information, go to [http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17) 
 * @param encrypted True if the upload is encrypted. False if it is not encrypted. If not specified, defaults to true.
 * @param zipped True if the upload is zipped. False if it is a single file. If not specified, defaults to true.
 * @param type UploadRequest
 */
@Serializable
internal data class UploadRequest (
    /* File name */
    @SerialName("name")
    val name: kotlin.String,
    /* The size of the object in bytes. A standard HTTP header. For more information, go to [http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.13](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.13)  */
    @SerialName("contentLength")
    val contentLength: kotlin.Long,
    /* The base64-encoded, 128-bit MD5 digest of the object body. */
    @SerialName("contentMd5")
    val contentMd5: kotlin.String,
    /* A standard MIME type. For more information, go to [http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17)  */
    @SerialName("contentType")
    val contentType: kotlin.String,
    /* True if the upload is encrypted. False if it is not encrypted. If not specified, defaults to true. */
    @SerialName("encrypted")
    val encrypted: kotlin.Boolean? = null,
    /* True if the upload is zipped. False if it is a single file. If not specified, defaults to true. */
    @SerialName("zipped")
    val zipped: kotlin.Boolean? = null,
    /* UploadRequest */
    @SerialName("type")
    val type: kotlin.String? = null
) {

}

