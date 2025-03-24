//Pig Latin is a game of alterations played on the English language game.
//the initial consonant sound is transposed to the end of the word and an ay is affixed (Ex.: "banana" would yield anana-bay).
fun main() {
    var mainStringInput = readln()
    val mainString = "${mainStringInput.first()}ay"
    mainStringInput = mainStringInput.drop(1)
    mainStringInput += '-'
    println("$mainStringInput$mainString")
}
