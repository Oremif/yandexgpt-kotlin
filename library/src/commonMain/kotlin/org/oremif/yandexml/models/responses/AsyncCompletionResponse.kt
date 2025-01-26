package org.oremif.yandexml.models.responses

import org.oremif.yandexml.models.data.ErrorStatusOperation
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

/**
 * An Operation resource
 *
 * @property id ID of the operation.
 * @property description Description of the operation. 0-256 characters-long.
 * @property createdAt Creation timestamp.
 * @property createdBy ID of the user or service account who initiated the operation.
 * @property modifiedAt The time when the Operation resource was last modified.
 * @property done If the value is `false`, it means the operation is still in progress.
 * If `true`, the operation is completed, and either `error` or `response` is available.
 * @property metadata Service-specific metadata associated with the operation.
 * It typically contains the ID of the target resource that the operation if performed on.
 * Any method that returns a long-running operation should document the metadata type, if any.
 * @property error The error result of the operation in case of failure or cancellation.
 *
 * Includes only of the fields `error`, `response`.
 *
 * The operation result.
 * If `done == false` and there was no filure detected, neither `error` nor `response` is set.
 * If `done == false` and there was a failure detected, `error` is set.
 * If `done == true`, exactly one of `error` or `response` is set.
 * @property response The normal response of the operation in case of success.
 *
 * Includes only of the fields `error`, `response`.
 *
 * The operation result.
 * If `done == false` and there was no filure detected, neither `error` nor `response` is set.
 * If `done == false` and there was a failure detected, `error` is set.
 * If `done == true`, exactly one of `error` or `response` is set.
 */
@Serializable
public data class AsyncCompletionResponse(
    val id: String,
    val description: String,
    val createdAt: LocalDateTime,
    val createdBy: String,
    val modifiedAt: LocalDateTime,
    val done: Boolean,
    val metadata: Map<String, String> = emptyMap(),
    val error: ErrorStatusOperation,
    val response: CompletionResponse
)