package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * The error result of the operation in case of failure or cancellation.
 *
 * @property code An error code. An enum value of [google.rpc.Code](https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto).
 * @property message An error message.
 * @property details A list of messages that carry the error details.
 */
@Serializable
public data class ErrorStatusOperation(
    val code: Int,
    val message: String,
    val details: List<Map<String, String>>
)