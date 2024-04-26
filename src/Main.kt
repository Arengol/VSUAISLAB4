import java.util.*

fun main() {
    val graph = mutableMapOf<Int, List<Int>>()
    //ввод данных пользователем и обработка ошибок
    try {
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
        print("Конечная вершина: ")
        val end = readln().toInt()
        println(dfs(graph, start, end).toString())
    }
    catch (e : Exception) {
        print("Неверный формат данных")
    }
}

// функция для обхода графа
fun dfs(graph: Map<Int, List<Int>>, start: Int, end: Int): Int {
    val visited = mutableSetOf<Int>()
    val stack = ArrayDeque<Int>()
    var pathLength = 0

    stack.push(start)

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        visited.add(current)

        if (current == end) {
            return pathLength
        }

        for (neighbor in graph[current] ?: emptyList()) {
            if (!visited.contains(neighbor)) {
                stack.push(neighbor)
                pathLength++
            }
        }
    }

    return -1
}
