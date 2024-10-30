package io.github.oremif.yandexgpt

import kotlinx.serialization.Serializable

@Serializable
public enum class AlternativeStatus {
    ALTERNATIVE_STATUS_UNSPECIFIED,
    ALTERNATIVE_STATUS_PARTIAL,
    ALTERNATIVE_STATUS_TRUNCATED_FINAL,
    ALTERNATIVE_STATUS_FINAL,
    ALTERNATIVE_STATUS_CONTENT_FILTER,
    ALTERNATIVE_STATUS_TOOL_CALLS
}

@Serializable
public data class Alternative(
    val message: YaGptMessage,
    val status: AlternativeStatus,

)