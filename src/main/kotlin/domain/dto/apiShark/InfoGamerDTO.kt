package domain.dto.apiShark

import com.google.gson.annotations.SerializedName

data class InfoGamerDTO(
    @SerializedName("nome") val name: String,
    val email: String,
    @SerializedName("dataNascimento") val birthDate: String,
    @SerializedName("usuario") val username: String
) {}