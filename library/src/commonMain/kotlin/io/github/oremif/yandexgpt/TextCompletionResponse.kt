package io.github.oremif.yandexgpt

import kotlinx.serialization.Serializable

/**
 * Response containnig generated text completions.
 * @property alternatives A list of generated completion alternatives.
 * @property usage A set of statistics describing the number of content tokens used by the completion model.
 * @property modelVersion The model version changes with each new releases.
 */
@Serializable
public data class TextCompletionResponse(
    val alternatives: List<Alternative>,
    val usage: Contentusage,
    val modelVersion: String
)