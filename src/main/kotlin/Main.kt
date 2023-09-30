import domain.entities.Gamer
import services.getGameService
import utils.parseToAge
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("______G_A_M_E___F_I_N_D_E_R______")
    println("\n")

    val gamer = Gamer.createGamer(scanner)
    println("You're in, ${gamer.name}!")
    println("You are ${gamer.birthDate.parseToAge()} years old")

    do {
        println("Type an game ID")
        val id = scanner.nextLine()

        val game = getGameService(id)

        gamer.searchedGames.add(game)

        println(game)

        println("Want to find a new game? (Y/N)")
        val response = scanner.nextLine()

    } while (response.equals("Y", true))

    println("Searched games:")
    gamer.searchedGames
        .sortedBy {it.title}
        .forEach { println(it) }
}