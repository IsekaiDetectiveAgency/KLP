import java.math.BigInteger
import kotlin.system.exitProcess

fun main() {
    var mainString: String = readln()
    val mainList: MutableList<String> = mutableListOf("")
    var mainListCopy:MutableList<String> = mutableListOf()
    var mainListCopy0:MutableList<String> = mutableListOf()
    var isAlreadyFull = false
    var didSpace = false
    var didSubAd = false
    var parantez = false
    var didParantez = false
    var didOperation = false
    var pastMainStringTransfer = ""
    var parantezOpenings = 0
    var parantezEndings = 0
    var didCloseParantez = false
    do {
        val mainStringTransfer = mainString.first().toString()
        mainString = mainString.drop(1)
        var mainListSize = mainList.size - 1
        when {
            mainStringTransfer == "-" -> {
                didParantez = false
                didOperation = false
                when {
                    pastMainStringTransfer == "-" -> {
                        mainList[mainListSize] = "+"; pastMainStringTransfer = "+"
                    }

                    pastMainStringTransfer == "+" -> {
                        mainList[mainListSize] = "-"; pastMainStringTransfer = "-"
                    }

                    else ->{if (didCloseParantez) {mainList += ""; mainListSize++; didCloseParantez = false}
                        if (isAlreadyFull) {
                        mainList += ""; mainList[mainListSize + 1] += mainStringTransfer;didSubAd =
                            true; isAlreadyFull = true; didSpace = false; pastMainStringTransfer = mainStringTransfer
                    } else {
                        mainList[mainListSize] += mainStringTransfer;didSubAd = true; isAlreadyFull = true; didSpace =
                            false; pastMainStringTransfer = mainStringTransfer
                    }}
                }
            }
            mainStringTransfer == "+" -> {
                didParantez = false
                didOperation = false
                pastMainStringTransfer = "+"
                    if (didCloseParantez) {mainList += ""; mainListSize++; didCloseParantez = false}
                        if (isAlreadyFull) {
                            mainList += "";didSubAd =
                                true; isAlreadyFull = true; didSpace = false; pastMainStringTransfer = mainStringTransfer
                        } else {
                            didSubAd = true; isAlreadyFull = true; didSpace =
                                false; pastMainStringTransfer = mainStringTransfer
                        }
            }

            mainStringTransfer == "%" || mainStringTransfer == "/" || mainStringTransfer == "*" -> if (!isAlreadyFull && !didParantez || didSubAd) error(errorC = 1) else {
                mainList += ""; mainList[mainListSize + 1] = mainStringTransfer; mainList += "";didSubAd =
                    false; isAlreadyFull = false; didSpace = false;didParantez = false;didOperation =
                    true;didCloseParantez = false; pastMainStringTransfer = mainStringTransfer
            }

            mainStringTransfer == " " -> didSpace = true
            mainStringTransfer == "(" -> {
                if (pastMainStringTransfer == ")") mainList[mainListSize] = "*"; if (didSubAd) {
                    if (pastMainStringTransfer == "+") {
                        mainList[mainListSize] = "null"; mainList -= mainList[mainListSize]; mainListSize--
                    } else if (pastMainStringTransfer == "-") mainList[mainListSize] += "1"
                }
                parantez = true; parantezOpenings++; didParantez = true; isAlreadyFull = false; didSubAd =
                    false; didSpace = false; didOperation =
                    false;didCloseParantez = false; if (mainList[mainListSize].isNotEmpty()) mainList += "(" else mainList[mainListSize] =
                    "(";mainList += ""; pastMainStringTransfer = mainStringTransfer
            }

            mainStringTransfer == ")" -> {if (!parantez)error(errorC = 2)
                if (didOperation || didSubAd || pastMainStringTransfer == "(") error(errorC = 3)
                parantezEndings++; didParantez = true; isAlreadyFull = false; didSubAd = false; didSpace =
                    false; didOperation = true;didCloseParantez = true; mainList += ")"; pastMainStringTransfer = mainStringTransfer
            }

            mainStringTransfer.toByteOrNull() != null -> if (didSpace && isAlreadyFull && !didSubAd) error(errorC = 4) else {
                if (pastMainStringTransfer == ")") {
                    mainList += "";mainList += "+"; mainListSize += 2;
                }
                mainList[mainListSize] += mainStringTransfer;didSubAd = false; isAlreadyFull = true; didSpace =
                    false;didParantez = false; didOperation = false;didCloseParantez = false; pastMainStringTransfer = mainStringTransfer
            }

            mainStringTransfer.toByteOrNull() == null -> error(errorC = 5)
        }
    } while (mainString.isNotEmpty())
    if (parantez) {
        if (parantezOpenings != parantezEndings) error(errorC = 6)

    }
    println(mainList)


    var mainListSize = mainList.size
    var mainListNumber = 0
    var didCalculate = false
    println(mainList)
    var parantezNum = 0
    var parantezLocationNum = 0
    var parantez0LocationNum = 0
    var isDoingParantez = false
    var lastparantez = false
    do {
        if (parantez)
            if (!lastparantez)do {
                when (mainList[mainListNumber]) {
                    "(" -> {
                        parantezNum++; parantezLocationNum = mainListNumber
                        println("parantez opening success")
                        println(mainList + "mainlist number is: " + mainListNumber)
                    }
                    ")" -> {
                        println("parantez closing start")
                        mainList[parantezLocationNum] = "null"
                        mainList -= mainList[parantezLocationNum]
                        mainListNumber--
                        parantez0LocationNum = mainListNumber
                        if (parantezNum == 0) error(errorC = 7)
                        var temp = 0
                        println("is doing parantez calculations mainList is $mainList")
                        if (parantezLocationNum > temp)do {
                            mainListCopy += mainList[0]
                            mainList[0] = "null"
                            mainList -= mainList[0]
                            temp++
                        } while (temp < parantezLocationNum)
                        println("did 1 out of 2 calculations mainListCopy is $mainListCopy and mainList is $mainList")
                        mainList[parantez0LocationNum -temp] = "null"
                        println("did null mainList is $mainList size is ${mainList.size} parantezNum is ${parantez0LocationNum -temp}")
                        mainList -= mainList[parantez0LocationNum -temp]
                        println("did remove null mainList is $mainList size is ${mainList.size} parantezNum is ${parantez0LocationNum -temp}")
                        temp = parantez0LocationNum -temp

                       if (temp < mainList.size) do {
                            mainListCopy0 += mainList[temp]
                            mainList[temp] = "null"
                            mainList -= mainList[temp]
                            println("doing 2 out of 2 stuff size is ${mainList.size} temp is $temp")
                        } while (temp < mainList.size)
                        println("did 2 out of 2 calculations mainListCopy0 is $mainListCopy0 and mainList is $mainList")
                        isDoingParantez = true
                        parantezOpenings--
                        parantezEndings--
                    }

                }
                println("got heere mainList number is: $mainListNumber")
                mainListNumber ++
            }while (!isDoingParantez)
            println("got here")
        mainListSize = mainList.size

        mainListNumber = 0
        do {
            if (didCalculate) {
                mainListSize = mainList.size; mainListNumber = 0; didCalculate = false
            }
            when (mainList[mainListNumber]) {
                "%" -> {
                    val temp =
                        mainList[mainListNumber - 1].toBigInteger() % mainList[mainListNumber + 1].toBigInteger(); mainList[mainListNumber - 1] =
                        temp.toString(); mainList[mainListNumber] =
                        "null"; mainList -= mainList[mainListNumber]; mainList[mainListNumber] =
                        "null"; mainList -= mainList[mainListNumber]; didCalculate = true
                }

                "/" -> {
                    val temp =
                        mainList[mainListNumber - 1].toBigInteger() / mainList[mainListNumber + 1].toBigInteger(); mainList[mainListNumber - 1] =
                        temp.toString(); mainList[mainListNumber] =
                        "null"; mainList -= mainList[mainListNumber]; mainList[mainListNumber] =
                        "null"; mainList -= mainList[mainListNumber]; didCalculate = true
                }

                "*" -> {
                    val temp =
                        mainList[mainListNumber - 1].toBigInteger() * mainList[mainListNumber + 1].toBigInteger(); mainList[mainListNumber - 1] =
                        temp.toString(); mainList[mainListNumber] =
                        "null"; mainList -= mainList[mainListNumber]; mainList[mainListNumber] =
                        "null"; mainList -= mainList[mainListNumber]; didCalculate = true
                }
            }
            mainListNumber++
        } while (mainListSize > mainListNumber)
        println("parantez is $parantez $mainList last parantez is $lastparantez parantez openings is $parantezOpenings parantez endings is $parantezEndings")
        if (mainList.size > 1)do {
            val temp = mainList[0].toBigInteger() + mainList[1].toBigInteger()
            mainList[0] = temp.toString()
            mainList[1] = "null"
            mainList -= mainList[1]
        } while (mainList.size > 1)
        println(mainList[0])
        println("loooooooooooooooooooooooooooooooooooooooooooooooooooool $mainList $mainListCopy")
        if (isDoingParantez){
            val mainListCopySize = mainListCopy.size
            if (mainListCopySize > 0){
                println("copy is  ${mainListCopy[mainListCopySize -1]} main is $mainList full copy is $mainListCopy int or null is ${mainListCopy[mainListCopySize -1].toBigIntegerOrNull()}")
                if (mainListCopy[mainListCopySize -1].toBigIntegerOrNull() != null){val temp0 = mainListCopy[mainListCopySize -1].toBigInteger() * mainList[0].toBigInteger()
            mainListCopy[mainListCopySize -1] = "null"
            mainListCopy -= mainListCopy[mainListCopySize -1]
            mainList[0] = temp0.toString()}else when(mainListCopy[mainListCopySize -1]){
                "%"->{val temp0 = mainListCopy[mainListCopySize -2].toBigInteger() % mainList[0].toBigInteger()
                    mainListCopy[mainListCopySize -2] = "null"
                    mainListCopy -= mainListCopy[mainListCopySize -2]
                    mainListCopy[mainListCopySize -2] = "null"
                    mainListCopy -= mainListCopy[mainListCopySize -2]
                    mainList[0] = temp0.toString()}
                "/"->{val temp0 = mainListCopy[mainListCopySize -2].toBigInteger() / mainList[0].toBigInteger()
                    mainListCopy[mainListCopySize -2] = "null"
                    mainListCopy -= mainListCopy[mainListCopySize -2]
                    mainListCopy[mainListCopySize -2] = "null"
                    mainListCopy -= mainListCopy[mainListCopySize -2]
                    mainList[0] = temp0.toString()}
                "*"->{val temp0 = mainListCopy[mainListCopySize -2].toBigInteger() * mainList[0].toBigInteger()
                    mainListCopy[mainListCopySize -2] = "null"
                    mainListCopy -= mainListCopy[mainListCopySize -2]
                    mainListCopy[mainListCopySize -2] = "null"
                    mainListCopy -= mainListCopy[mainListCopySize -2]
                    mainList[0] = temp0.toString()}
            }}
            println("parantez detected adding values back")
            mainListCopy += mainList[0]
            mainListCopy += mainListCopy0
            println("added values back after parantez they are = $mainListCopy")
            mainList -= mainList
            println("mainList got cleared mainList is $mainList")
            mainList += mainListCopy
            println("added mainListCopied values back to mainList mainList is $mainList")
            mainListCopy -= mainListCopy
            mainListCopy0 -= mainListCopy0
            println("cleared mainListCopy and mainListCopy0 mainListCopy: $mainListCopy mainListCopy0: $mainListCopy0")
            isDoingParantez = false
            if (lastparantez)parantez = false
            if (parantezOpenings == 0 && parantezEndings == 0)lastparantez = true

        }
        if (lastparantez && mainList.size == 1)parantez = false
    }while(parantez)
    println(mainList[0])
    println("parantez is $parantez")
}
fun error(errorC: Byte){
    println("wrong format")
    exitProcess(errorC.toInt())
}
