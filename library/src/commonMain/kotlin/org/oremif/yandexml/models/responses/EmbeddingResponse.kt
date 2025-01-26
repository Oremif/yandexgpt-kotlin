package org.oremif.yandexml.models.responses

import kotlinx.serialization.Serializable


/**
 * Response containing generated text embedding.
 *
 * @property embedding A repeated list of double values representing the embedding.
 * @property numTokens String (int64) — The number of tokens in the input text.
 * @property modelVersion The model version changes with each new release.
 */
@Serializable
public data class EmbeddingResponse(
    val embedding: List<String>,
    val numTokens: String,
    val modelVersion: String
)