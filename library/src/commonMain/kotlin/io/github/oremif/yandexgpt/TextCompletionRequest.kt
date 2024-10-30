package io.github.oremif.yandexgpt

import kotlinx.serialization.Serializable

/**
 * Request for the service to generate text completion.
 *
 * @property modelUri The [ID of the model](https://yandex.cloud/en/docs/foundation-models/concepts/yandexgpt/models) to be used for completion generation.
 * @property completionOptions Configuration options for completion generation.
 * @property messages A list of messages representing the context for the completion model.
 * @property tools List of tools that are avaibale for the model to invoke during the completion generation.
 * _Note_: This parameter is not yet supported and will be ignored if provided.
 */
@Serializable
public data class TextCompletionRequest(
    val modelUri: String,
    val completionOptions: CompletionOptions,
    val messages: List<YaGptMessage>,
    val tools: List<YaGptTool>? = null,
)