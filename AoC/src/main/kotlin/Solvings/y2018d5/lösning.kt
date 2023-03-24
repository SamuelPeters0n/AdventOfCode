package Solvings.y2018d5

import java.io.File


fun main() {
    println(react2(File("src/main/kotlin/Solvings/y2018d5/input.txt").readText()))
}

private fun react2(input: String) : Int {
    val string = StringBuilder(input)

    while(true) {
        var changes = false

        for(i in (0 until string.length - 1)) {
            if(string[i].lowercaseChar() == string[i + 1].lowercaseChar() && string[i] != string[i + 1]) {
                string.delete(i, i + 2)
                changes = true
                break
            }
        }

        if(!changes) {
            break
        }
    }

    return string.length
}