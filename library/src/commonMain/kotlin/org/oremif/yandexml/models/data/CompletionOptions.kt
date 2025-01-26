package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * Options for completion generation.
 *
 * @property stream Enables streaming of partially generated text. Default: **false**.
 * @property temperature Affects creativity and randomness of responses. Should be a double number between 0 (inclusive) and 1 (inclusive).
 * Lower values produce more straightforward responses, while higher values lead to increased creativity and randomness.
 * Default temperature: 0.3
 * @property maxTokens The limit on the number of tokens used for single completion generation.
 * Must be greater than zero. This maximum allowed parameter value may depend on the model being used.
 */
@Serializable
public data class CompletionOptions(
    val stream: Boolean = false,
    val temperature: Double = 0.3,
    val maxTokens: Long = 1000 // TODO(check default value for max tokens)
)