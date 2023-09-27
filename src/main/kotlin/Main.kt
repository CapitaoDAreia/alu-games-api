
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    val client: HttpClient = HttpClient.newHttpClient();

    //build request
    val request: HttpRequest = HttpRequest
        .newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    //do request and catch response
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body();

    println(json)
}