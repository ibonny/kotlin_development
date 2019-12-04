@file:DependsOn("khttp:khttp:0.1.0")
@file:DependsOn("com.beust:klaxon:5.0.12")

import khttp.get

import com.beust.klaxon.Klaxon
import com.beust.klaxon.JsonObject
import java.io.StringReader

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: String
)

val header = mapOf(
    "

val result = get("http://jsonplaceholder.typicode.com/todos")

val jsonData = Klaxon().parseJsonArray(StringReader(result.text))

for (entry in jsonData) {
    val obj = entry as JsonObject

    println("${obj.int("id")} ${obj.string("title")}")
}
