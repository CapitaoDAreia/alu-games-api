package domain.dto.apiShark

import com.google.gson.annotations.SerializedName
import domain.entities.Gamer

data class InfoGamerDTO(
    @SerializedName("nome") val name: String,
    val email: String,
    @SerializedName("dataNascimento") val birthDate: String,
    @SerializedName("usuario") val username: String
) {
    fun createGamer(): Gamer {
        return Gamer(
            this.name,
            this.email,
            this.birthDate,
            this.username
        )
    }
}