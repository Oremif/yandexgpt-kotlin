package org.oremif.yandexml.models.requests

import kotlinx.serialization.Serializable

/**
 * Request for the service to classify text.
 *
 * @property modelUri The identifier of the classification model.
 * @property text Text for classification.
 */
@Serializable
public data class ClassificationRequest(
    val modelUri: String,
    val text: String
)