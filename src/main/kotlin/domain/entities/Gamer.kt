package domain.entities

import java.time.LocalDate
import kotlin.random.Random

data class Gamer(var name: String, var email: String, val birthDate: LocalDate, var user: String) {
    var id: String? = null
        private set

    init {
        this.generateId()
        this.validateEmail()
        this.validateName()
    }

    private fun generateId() {
        if (this.user.isBlank()) throw Exception("invalid user")

        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        this.id = "$user#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        val regexResult = regex.matches(this.email);

        if (regexResult) return email
        throw Exception("invalid email: ${this.email}")
    }

    private fun validateName(){
        if(this.name.isBlank()) throw Exception("invalid name")
    }

    override fun toString(): String {
        return "Gamer email: ${this.email}, user: ${this.user}"
    }
}
