import domain.entities.Gamer
import services.getGameService
import services.getGamerService
import utils.extractAgeFromBirthDate
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("______G_A_M_E___F_I_N_D_E_R______")
    println("\n")

    val gamer = Gamer.createGamer(scanner)
    println("You're in, ${gamer.name}!")
    println("You are ${gamer.birthDate.extractAgeFromBirthDate()} years old")

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
        .sortedBy { it.title }
        .forEach { println(it) }

    val gamers = getGamerService()
    println(gamers)

//    val gamer = getGamerService().get(1)
//    val game = getGameService("150")
//    val period = Period(LocalDate.now(), LocalDate.now().plusDays(7))
//    val rent = gamer.rentGame(game, period)
//    println(rent.toString())
}