package org.oremif.yandexml.models.data

public data class YaGptModelName(val modelName: String) {
    public companion object {
        public val LITE: YaGptModelName = YaGptModelName("yandexgpt-lite")
        public val PRO: YaGptModelName = YaGptModelName("yandexgpt")
        public val PRO_32K: YaGptModelName = YaGptModelName("yandexgpt-32k")
    }

    override fun toString(): String = modelName
}

public data class YaEmbModelName(val modelName: String) {
    public companion object {
        public val TEXT_SEARCH_DOC: YaEmbModelName = YaEmbModelName("text-search-doc")
        public val TEXT_SEARCH_QUERY: YaEmbModelName = YaEmbModelName("text-search-query")
    }

    override fun toString(): String = modelName
}