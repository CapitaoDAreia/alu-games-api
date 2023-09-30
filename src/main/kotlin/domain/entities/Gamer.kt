package domain.entities

import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String, val birthDate: String, var user: String) {
    var id: String? = null
        private set

    val searchedGames = mutableListOf<Game>()

    val accumulatedRents = mutableListOf<Rent>()

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

    private fun rentGame(game: Game): Rent{
        val rent = Rent(this, game)
        this.accumulatedRents.add(rent)
        return rent
    }

    override fun toString(): String {
        return "Gamer email: ${this.email}, user: ${this.user}"
    }

    companion object{
        fun createGamer(scanner: Scanner): Gamer {
            println("Type your name")
            val name = scanner.nextLine();
            println("Type your email")
            val email = scanner.nextLine();
            println("Type your birthDate (dd/mm/yyyy)")
            val birthDate = scanner.nextLine();
            println("Type your username")
            val userName = scanner.nextLine();

            return Gamer(name, email, birthDate, userName)
        }
    }
}
