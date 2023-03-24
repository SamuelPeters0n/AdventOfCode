package Solvings.y2021d6

import java.io.File


fun main() {
    val input = File("src/main/kotlin/Solvings/y2021d6/input.txt").readText()
    var list = input.split(',').map{it.toInt()}.toMutableList()

    println(simulateXDays(list ,80))
}


fun simulateXDays(list: MutableList<Int>, days : Int): Int{
    for (i in 0 until days){
        var newFish = 0
        for (i in 0 until list.size){

            if (list[i] == 0){
                list[i] = 6
                newFish++
            }else {
                list[i] -= 1
            }


        }
        for (i in 0 until newFish) {
            list.add(8)
        }

    }
    return list.size
}