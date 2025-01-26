package org.oremif.yandexml.models.requests

import kotlinx.serialization.Serializable

/**
 * Request for the service to tokenize input text.
 *
 * @property modelUri The id of the model to be used for tokenization.
 * @property text Text to be tokenized.
 */
@Serializable
public data class TokenizeRequest(
    val modelUri: String,
    val text: String
)