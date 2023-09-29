package providers

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun sharkApiProvider(uri: String): HttpResponse<String> {
    return try {
        val client: HttpClient = HttpClient.newHttpClient()

        val request: HttpRequest = HttpRequest
            .newBuilder()
            .uri(URI.create(uri))
            .build()
        client.send(request, HttpResponse.BodyHandlers.ofString())

    } catch (ex: Exception) {
        throw Exception("request has failed")
    }
}