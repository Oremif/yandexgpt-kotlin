package org.oremif.yandexml.models.responses

import org.oremif.yandexml.models.data.ClassificationLabel
import kotlinx.serialization.Serializable

/**
 * Response containing classifier predictions.
 *
 * @property predictions Result of classification — a list of label-confidence pairs.
 * @property modelVersion Model version (changes with model releases).
 */
@Serializable
public data class ClassificationResponse(
    val predictions: List<ClassificationLabel>,
    val modelVersion: String
)