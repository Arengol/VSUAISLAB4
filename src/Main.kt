import java.util.*

fun main() {
    val graph = mutableMapOf<Int, List<Int>>()
    print("Колличество вершин: ")
    val count = readln().toInt()
    for (i in 1..count) {
        print("Смежные вершины для вершины $i: ")
        val input = readln()
        if (input.isNotEmpty())
            graph[i] = input.split(" ").map { it.toInt() }
    }
    print("Стартовая вершина: ")
    val start = readln().toInt()
    println(dfs(graph, start).toString())
}

fun dfs(graph: Map<Int, List<Int>>, start: Int): List<Int> {
    val visited = mutableSetOf<Int>()
    val stack = Stack<Int>()
    val longestPath = mutableListOf<Int>()

    stack.add(start)

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        visited.add(current)
        longestPath.add(current)

        for (neighbor in graph[current] ?: emptyList()) {
            if (!visited.contains(neighbor)) {
                stack.push(neighbor)
            }
        }
    }

    return longestPath
}
