package kotlin_development

import khttp.get
import kotlinx.serialization.*
import kotlinx.serialization.json.*

import krangl.*

fun fibonacci(n: Int): Int {
    if (n == 1 || n == 2) {
        return 1
    }

    return fibonacci(n-1) + fibonacci(n-2)
}

fun get_data(url: String): String {
    val r = get(url)

    return r.text
}

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

fun loadTodoData() {
    val text = get_data("http://jsonplaceholder.typicode.com/todos")

    println(text)

    val json = Json(JsonConfiguration.Stable)

    val objs = json.parse(Todo.serializer().list, text)

    for (obj in objs) {
        println("${obj.id}, ${obj.userId}, ${obj.title}, ${obj.completed}")
    }
}

fun String.runCommand(): String? {
    try {
        val parts = this.split("\\s".toRegex())
        val proc = ProcessBuilder(*parts.toTypedArray())
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE)
                .start()

        proc.waitFor(60, TimeUnit.MINUTES)
        return proc.inputStream.bufferedReader().readText()
    } catch(e: IOException) {
        e.printStackTrace()
        return null
    }
}

fun testDataframes() {
    val df: DataFrame = dataFrameOf("col1", "col2") (
        1, 2,
        3, 4,
        5, 6
    )

    println(df)
}

fun main(args: Array<String>) {
    // loadTodoData()

    testDataframes()
}
