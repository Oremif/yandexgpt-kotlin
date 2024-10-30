//package io.github.oremif.yandexgpt
//
//public fun Cohere(token: String, body: Cohere.Builder.() -> Unit): Cohere {
//    val config = Cohere.Builder().apply(body)
//    val ktorClient = HttpClient {
//        install(Auth) {
//            bearer { loadTokens { BearerTokens(token, "") } }
//        }
//
//        install(ContentNegotiation) {
//            json(config.jsonConfig)
//        }
//
//        defaultRequest {
//            url(config.baseUrl)
//            contentType(ContentType.Application.Json)
//            if (config.clientName != null) {
//                header("X-Client-Name", config.clientName)
//            }
//        }
//
//        install(HttpRequestRetry) {
//            maxRetries = 3
//            retryIf { _, response -> !response.status.isSuccess() }
//            delayMillis { retry ->
//                val delay = (retry * 0.2).toLong().coerceAtLeast(1L)
//                retry + Random.nextLong(delay)
//            }
//        }
//
//        install(Logging) {
//            logger = Logger.DEFAULT
//            level = LogLevel.HEADERS
//            sanitizeHeader { header -> header == "Authorization" }
//        }
//    }
//
//    return Cohere(ktorClient)
//}
//
//public fun <T : HttpClientEngineConfig> Cohere(
//    engineFactory: HttpClientEngineFactory<T>,
//    block: HttpClientConfig<T>.() -> Unit = {}
//): Cohere {
//    val ktorClient = HttpClient(engineFactory, block)
//    val client = Cohere(ktorClient)
//
//    return client
//}
//
//public class Cohere internal constructor(public val client: HttpClient) : AutoCloseable {
//
//    public suspend fun chat(request: ChatRequest): ChatResponse =
//        client.post("/chat") { setBody(request.apply { if (stream == true) stream = false }) }.body<ChatResponse>()
//
//    public suspend fun chat(message: String, body: ChatRequest.Builder.() -> Unit): ChatResponse =
//        chat(ChatRequest.Builder(message).apply(body).build())
//
//    public suspend fun chatStream(request: ChatRequest): Flow<ChatStreamResponse> {
//        return flow {
//            client.post("/chat") {
//                setBody(request.apply { if (stream == false) stream = true })
//                accept(ContentType.Text.EventStream)
//                headers {
//                    append(HttpHeaders.CacheControl, "no-cache")
//                    append(HttpHeaders.Connection, "keep-alive")
//                }
//            }
//        }
//    }
//
//    public suspend fun chatStream(message: String, body: ChatRequest.Builder.() -> Unit): Flow<ChatStreamResponse> =
//        chatStream(ChatRequest.Builder(message, true).apply(body).build())
//
//    public class Builder internal constructor() {
//        internal var clientName: String? = null
//        internal var baseUrl: String = Environment.PRODUCTION_URL
//        internal var jsonConfig: Json = Environment.JSON_CONFIG
//
//        public fun clientName(name: String): Unit = let { clientName = name }
//        public fun baseUrl(url: String): Unit = let { baseUrl = url }
//        public fun jsonConfig(config: Json): Unit = let { jsonConfig = config }
//    }
//
//    override fun close() {
//        client.close()
//    }
//}