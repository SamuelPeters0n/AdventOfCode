package Solvings.y2022d5

import java.io.File
import java.util.*


fun String.toOrder(): Order {
    val parts = this.split(" ")
    return Order(parts[1].toInt(), parts[3].toInt() - 1, parts[5].toInt() - 1)
}

typealias Stacks = List<Stack<Char>>
typealias Movements = List<Order>

fun parseStacksAndMovements(): Pair<Stacks, Movements> {
    val (stacksString, movementsString) = File(
        "src/main/kotlin/Solvings/y2022d5/input.txt"
    )
        .readText()
        .split("\n\n")

    val stackLines = stacksString.split("\n")

    val numberOfStacks = stackLines.last().split("  ").size

    val stacks = List(numberOfStacks) { Stack<Char>() }
    for (row in stackLines.subList(0, toIndex = stackLines.lastIndex)) {
        for (itemIndex in 1 until row.length step 4) {
            val letter = row[itemIndex]
            if (letter == ' ') continue

            stacks[(itemIndex - 1) / 4].push(letter)
        }
    }

    val movements = movementsString.lines().map(String::toOrder)

    return stacks to movements
}

fun main() {
val (stacks, orders) = parseStacksAndMovements()
    val o = Order(0,0,0)

    val finishedStacks = o.executeOrders(orders as MutableList<Order>, stacks.toMutableList())
    finishedStacks.forEach { println(it.get(0)) }

}

class Order(val howMany: Int, val fromWhatStack: Int, val toWhatStack: Int) {


    fun executeOrders(
        allOrders: MutableList<Order>, stacksList: MutableList<MutableList<Char>>): MutableList<MutableList<Char>> {


        for (order in allOrders) {
            val howMany = order.howMany
            val fromWhatStack = order.fromWhatStack
            val toWhatStack = order.toWhatStack

            for (i in 0 until howMany) {
                stacksList.get(toWhatStack ).add(0, stacksList.get(fromWhatStack ).get(0))
                stacksList.get(fromWhatStack ).removeFirst()
            }
        }
        return stacksList
    }
}