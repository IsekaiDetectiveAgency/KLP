fun main() {
    do { println()
        println()
        println()
        var doCheck:String
        var phrase = readln()
        var result=""
        var lengh:Int
        do {
            lengh = phrase.length - 1
            result += phrase.substring(lengh)
            phrase = phrase.dropLast(1)
        }while (lengh >= 1)
        println(result)
        do {
            println("redo? (n/y)")
            doCheck = readln().trim().lowercase()
        }while (doCheck != "n" && doCheck != "no" && doCheck != "y" && doCheck != "yes" && doCheck != "redo" && doCheck != "yep" && doCheck != "another" && doCheck != "do" && doCheck != "another one")
    }while (doCheck == "y" || doCheck == "yes" || doCheck == "redo" || doCheck == "yep" || doCheck == "another" || doCheck == "do" || doCheck == "another one")
}
