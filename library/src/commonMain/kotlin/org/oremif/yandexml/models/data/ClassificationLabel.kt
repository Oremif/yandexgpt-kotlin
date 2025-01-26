package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * A pair of text label and corresponding confidence used in classification problems.
 *
 * @property label A label with a class name.
 * @property confidence Confidence of an item belonging to a class.
 */
@Serializable
public data class ClassificationLabel(
    val label: String,
    val confidence: String
)