package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * Description of a sample for the classification task.
 *
 * @property text Text sample.
 * @property label Expected label for a given text.
 */
@Serializable
public data class ClassificationSample(
    val text: String,
    val label: String
)