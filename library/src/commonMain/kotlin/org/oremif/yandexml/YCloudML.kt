package org.oremif.yandexml

import org.oremif.yandexml.models.data.YaEmbModelName
import org.oremif.yandexml.models.data.YaGptModelName
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import kotlin.random.Random

public fun YCloudMlClient(
    token: String,
    folderId: String,
    body: YCloudMlClient.Builder.() -> Unit = {}
): YCloudMlClient {
    return YCloudMlClient.Builder().apply(body).build(token)
}

public class YCloudMlClient private constructor(
    private val client: HttpClient,
    private val clientConfig: YCloudMlClientConfig
) : AutoCloseable {

    private val gptModelUri: String? =
        clientConfig.gptModelName?.let { "gpt://${clientConfig.folderId}/$it/${clientConfig.gptModelVersion.version}" }
    private val embeddingModelUri: String? =
        clientConfig.embModelName?.let { "emb://${clientConfig.folderId}/$it/${clientConfig.embModelVersion.version}" }
    private val llmBaseUrl: String = "https://llm.api.cloud.yandex.net/foundationModels/v1/"
    private val operationBaseUrl: String = "https://operation.api.cloud.yandex.net/operations"

    public class Builder {
        private var folderId: String = ""
        private var gptModelName: YaGptModelName? = null
        private var emdModelName: YaEmbModelName? = null
        private var gptModelVersion: ModelVersion = ModelVersion.LATEST
        private var embModelVersion: ModelVersion = ModelVersion.LATEST

        @OptIn(ExperimentalSerializationApi::class)
        private var jsonConfig: Json = Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
            encodeDefaults = true
            decodeEnumsCaseInsensitive = true
            namingStrategy = JsonNamingStrategy.SnakeCase
        }

        public fun folderId(folderId: String): Builder = apply { this.folderId = folderId }
        public fun jsonConfig(jsonConfig: Json): Builder = apply { this.jsonConfig = jsonConfig }
        public fun gptModelName(modelName: YaGptModelName): Builder = apply { this.gptModelName = modelName }
        public fun emdModelName(modelName: YaEmbModelName): Builder = apply { this.emdModelName = modelName }
        public fun gptModelVersion(modelVersion: ModelVersion): Builder = apply { this.gptModelVersion = modelVersion }
        public fun embModelVersion(modelVersion: ModelVersion): Builder = apply { this.embModelVersion = modelVersion }

        public fun build(token: String): YCloudMlClient {
            val client = HttpClient {
                install(Auth) {
                    bearer { loadTokens { BearerTokens(token, "") } }
                }

                install(ContentNegotiation) { json(jsonConfig) }

                defaultRequest { contentType(ContentType.Application.Json) }

                install(HttpRequestRetry) {
                    maxRetries = 3
                    retryIf { _, response -> !response.status.isSuccess() }
                    delayMillis { retry ->
                        val delay = (retry * 0.2).toLong().coerceAtLeast(1L)
                        retry + Random.nextLong(delay)
                    }
                }

                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.HEADERS
                    sanitizeHeader { header -> header == "Authorization" }
                }
            }

            val config = YCloudMlClientConfig(folderId, gptModelName, emdModelName, gptModelVersion, embModelVersion)

            return YCloudMlClient(client, config)
        }
    }

    override fun close() {
        client.close()
    }
}