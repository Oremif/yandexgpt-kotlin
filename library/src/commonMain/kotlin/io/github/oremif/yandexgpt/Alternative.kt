package io.github.oremif.yandexgpt

import kotlinx.serialization.Serializable

/**
 * Represents the generation status of an alternative.
 */
@Serializable
public enum class AlternativeStatus {
    /** Unspecified generation status. */
    ALTERNATIVE_STATUS_UNSPECIFIED,

    /** Partially generated alternative. */
    ALTERNATIVE_STATUS_PARTIAL,

    /** Incomplete final alternative resulting from reaching the maximum allowed number of tokens. */
    ALTERNATIVE_STATUS_TRUNCATED_FINAL,

    /** Final alternative generated without running into any limits. */
    ALTERNATIVE_STATUS_FINAL,

    /** Generation was stopped due to the discovery of potentially sensitive content in the prompt or generated response. */
    ALTERNATIVE_STATUS_CONTENT_FILTER,

    /** Tools were invoked during the completion generation. */
    ALTERNATIVE_STATUS_TOOL_CALLS
}

/**
 * Represents a generated completion alternative, including its content and generation status.
 *
 * @property message A message containing the content of the alternative.
 * @property status The generation status of the alternative.
 */
@Serializable
public data class Alternative(
    val message: YaGptMessage,
    val status: AlternativeStatus,
)