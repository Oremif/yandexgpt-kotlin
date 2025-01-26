package org.oremif.yandexml.models.requests

import org.oremif.yandexml.models.data.ClassificationSample
import kotlinx.serialization.Serializable

/**
 * Request for the service to few-shot text classification.
 *
 * @property modelUri The identifier of the classification model.
 * @property taskDescription Text description of the classification task.
 * @property labels List of available labels for the classification result.
 * @property text Text for classification.
 * @property samples Optional set of text samples with expected labels that may be used as an additional hint for the classifier.
 */
@Serializable
public data class FewShotClassificationRequest(
    val modelUri: String,
    val taskDescription: String,
    val labels: List<String>,
    val text: String,
    val samples: List<ClassificationSample>? = null
)