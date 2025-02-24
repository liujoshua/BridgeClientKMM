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
package org.sagebionetworks.bridge.kmm.shared.models

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

/**
 * A description of the participant's consent status in a particular subpopulation (consent group). This object is never used to update state on the server (all fields are read only).  
 * @param name The name of the subpopulation.
 * @param subpopulationGuid The GUID for the subpopulation of this consent.
 * @param required Is this consent required? If required, the user must consent to it before being given access to the server (until signed, a 412 response is returned for most participant endpoints). 
 * @param signedOn The date and time the referenced consent was signed and agreed to by the participant. If there is a signedOn value, consented will be equal to true.
 * @param consented Has the participant consented to this consent agreement? If the user has signed this consent, there should be a signedOn timestamp value.
 * @param signedMostRecentConsent Was the consent to participate made against the most recently published version of this consent? If there's no signature this will be false (not null). 
 * @param type ConsentStatus
 */
@Serializable
data class ConsentStatus (
    /* The name of the subpopulation. */
    @SerialName("name")
    val name: kotlin.String? = null,
    /* The GUID for the subpopulation of this consent. */
    @SerialName("subpopulationGuid")
    val subpopulationGuid: kotlin.String? = null,
    /* Is this consent required? If required, the user must consent to it before being given access to the server (until signed, a 412 response is returned for most participant endpoints).  */
    @SerialName("required")
    val required: kotlin.Boolean? = null,
    /* The date and time the referenced consent was signed and agreed to by the participant. If there is a signedOn value, consented will be equal to true. */
    @SerialName("signedOn")
    val signedOn: kotlin.String? = null,
    /* Has the participant consented to this consent agreement? If the user has signed this consent, there should be a signedOn timestamp value. */
    @SerialName("consented")
    val consented: kotlin.Boolean? = null,
    /* Was the consent to participate made against the most recently published version of this consent? If there's no signature this will be false (not null).  */
    @SerialName("signedMostRecentConsent")
    val signedMostRecentConsent: kotlin.Boolean? = null,
    /* ConsentStatus */
    @SerialName("type")
    val type: kotlin.String? = null
) {

}

