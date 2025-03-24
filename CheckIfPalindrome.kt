//Checks if the string entered by the user is a palindrome.
fun main() {
    val mainInput = readln().lowercase().trim()
    var mainString = mainInput
    var mainString0 = ""
    do {mainString0 += mainString.last()
        mainString = mainString.dropLast(1)
    }while (mainString.isNotEmpty())
    if (mainString0 == mainInput) println("$mainInput is Palindrome")else println("$mainInput isn't Palindrome")
}
