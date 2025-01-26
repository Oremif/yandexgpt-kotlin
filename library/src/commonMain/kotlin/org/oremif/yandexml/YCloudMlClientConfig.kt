package org.oremif.yandexml

import org.oremif.yandexml.models.data.YaEmbModelName
import org.oremif.yandexml.models.data.YaGptModelName

public data class YCloudMlClientConfig(
    val folderId: String,
    val gptModelName: YaGptModelName?,
    val embModelName: YaEmbModelName?,
    val gptModelVersion: ModelVersion = ModelVersion.LATEST,
    val embModelVersion: ModelVersion = ModelVersion.LATEST,
)

public enum class ModelVersion(public val version: String) {
    LATEST("latest"), RC("rc"), DEPRECATED("deprecated")
}