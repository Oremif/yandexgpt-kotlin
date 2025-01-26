package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * A message class representing a wrapper over the inputs and outputs of the completion model.
 *
 * @property role The ID of the message sender. Supported roles:
 * - `system`: Special role used to define the behavior of the completion model.
 * - `assistant`: A role used by the model to generate responses.
 * - `user`: A role used by the user to describe requests to the model.
 * @property text Textual content of the message.
 *
 * Includes only one of the fields `text`, `toolCallList`, `toolResultList`.
 * @property toolCallList List of tool calls made by the model as part of the response generation.
 *
 * Includes only one of the fields `text`, `toolCallList`, `toolResultList`.
 * @property toolResultList List of tool results returned from external tools that were invoked by the model.
 *
 * Includes only one of the fields `text`, `toolCallList`, `toolResultList`.
 */

@Serializable
public data class YaGptMessage(
    val role: String,
    val text: String? = null,
    val toolCallList: ToolCallList? = null,
    val toolResultList: ToolResultList? = null
)