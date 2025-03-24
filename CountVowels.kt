//Enter a string and the program counts the number of vowels in the text. it reports a sum of each vowel found.
fun main() {
    var mainStringInput = readln().lowercase().trim()
    val mainStringInputLength = mainStringInput.length
    var pastTransfer = '.'
    var vowels = 0
    var shownString = ""
    var temp = 0
    if (temp < mainStringInputLength)do {
        val mainStringTransfer = mainStringInput.first()
        mainStringInput = mainStringInput.drop(1)
        when(mainStringTransfer){
            'a' ->{if (pastTransfer == 'a' || pastTransfer == 'e'|| pastTransfer == 'i'|| pastTransfer == 'o'|| pastTransfer == 'u')vowels-- ;vowels++; pastTransfer = mainStringTransfer}
            'e' ->{if (pastTransfer == 'a' || pastTransfer == 'e'|| pastTransfer == 'i'|| pastTransfer == 'o'|| pastTransfer == 'u')vowels-- ;vowels++; pastTransfer = mainStringTransfer}
            'i' ->{if (pastTransfer == 'a' || pastTransfer == 'e'|| pastTransfer == 'i'|| pastTransfer == 'o'|| pastTransfer == 'u')vowels-- ;vowels++; pastTransfer = mainStringTransfer}
            'o' ->{if (pastTransfer == 'a' || pastTransfer == 'e'|| pastTransfer == 'i'|| pastTransfer == 'o'|| pastTransfer == 'u')vowels-- ;vowels++; pastTransfer = mainStringTransfer}
            'u' ->{if (pastTransfer == 'a' || pastTransfer == 'e'|| pastTransfer == 'i'|| pastTransfer == 'o'|| pastTransfer == 'u')vowels-- ;vowels++; pastTransfer = mainStringTransfer}
            'y' ->{if (pastTransfer == 'a' || pastTransfer == 'e'|| pastTransfer == 'i'|| pastTransfer == 'o'|| pastTransfer == 'u'){}else{vowels++; pastTransfer = mainStringTransfer};}
            ' '->{if (shownString.isNotEmpty())shownString+= " "; shownString += vowels.toString(); vowels = 0}
            else->{pastTransfer = mainStringTransfer}
        }
        temp++
    }while (temp < mainStringInputLength)
    if (shownString.isNotEmpty())shownString+= " "; shownString += vowels.toString()
    println(shownString)
}
