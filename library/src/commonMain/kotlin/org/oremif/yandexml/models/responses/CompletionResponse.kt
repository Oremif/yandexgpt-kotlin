package org.oremif.yandexml.models.responses

import org.oremif.yandexml.models.data.Alternative
import org.oremif.yandexml.models.data.ContentUsage
import kotlinx.serialization.Serializable

/**
 * Response containing generated text completions.
 * @property alternatives A list of generated completion alternatives.
 * @property usage A set of statistics describing the number of content tokens used by the completion model.
 * @property modelVersion The model version changes with each new release.
 */
@Serializable
public data class CompletionResponse(
    val alternatives: List<Alternative>,
    val usage: ContentUsage,
    val modelVersion: String
)