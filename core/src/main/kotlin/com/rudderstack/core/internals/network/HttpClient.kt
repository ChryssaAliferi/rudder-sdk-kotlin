package com.rudderstack.core.internals.network

import java.net.HttpURLConnection
import java.net.URL

interface HttpClient {
    val baseUrl: String
    val endPoint: String
    val authHeaderString: String
    val getConfig: GetConfig
    var postConfig: PostConfig
    val customHeaders: Map<String, String>
    val connectionFactory: HttpURLConnectionFactory

    fun updateAnonymousIdHeaderString(anonymousIdHeaderString: String)

    fun getData(): Result<String>

    fun sendData(body: String): Result<String>
}

interface GetConfig {
    val query: Map<String, String>
}

interface PostConfig {
    val isGZIPEnabled: Boolean
    val anonymousIdHeaderString: String
}

interface HttpURLConnectionFactory {
    fun createConnection(
        url: URL,
        headers: Map<String, String>,
    ): HttpURLConnection
}
