package org.oremif.yandexml.models.requests

import kotlinx.serialization.Serializable


/**
 * Request for the service to get text embeddings.
 *
 * @property modelUri The [ID of the model](https://yandex.cloud/en/docs/foundation-models/concepts/embeddings) for getting text embeddings.
 * @property text The input text for which the embedding is requested.
 */
@Serializable
public data class EmbeddingRequest(
    val modelUri: String,
    val text: String
)