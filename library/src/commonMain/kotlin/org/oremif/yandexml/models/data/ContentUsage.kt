package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * An object representing the number of content tokens used by the completion model.
 *
 * @property inputTextTokens The number of tokens in the textual part of the model input.
 * @property completionTokens The total number of tokens in the generated completions.
 * @property totalTokens The total number of tokens, including all input tokens and all generated tokens.
 */
@Serializable
public data class ContentUsage(
    val inputTextTokens: String,
    val completionTokens: String,
    val totalTokens: String
)