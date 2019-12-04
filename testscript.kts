@file:DependsOn("khttp:khttp:0.1.0")
@file:DependsOn("com.beust:klaxon:5.0.12")

import khttp.get

import com.beust.klaxon.Klaxon
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonArray
import com.beust.klaxon.PathMatcher

import java.util.regex.Pattern

import java.io.StringReader

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: String
)

//val result = get("http://jsonplaceholder.typicode.com/todos")

//val jsonData = Klaxon().parseJsonArray(StringReader(result.text))

//for (entry in jsonData) {
//    val obj = entry as JsonObject

//    println("${obj.int("id")} ${obj.string("title")}")
//}

val result = get("https://ghibliapi.herokuapp.com/films")

val jsonData = Klaxon()
    .parseJsonArray(StringReader(result.text))
    .filter { 
        val obj = it as JsonObject

        obj.string("title")?.contains("the")!!
    }
    // .map {
    //     val obj = it as JsonObject

    //     obj.string("title")!!
    // }

// for (entry in jsonData) {
//     // This cast is required for some reason, as it's not recognized as a JsonObject beforehand.
//     val obj = entry as JsonObject

//     println("${obj.string("id")} ${obj.string("title")}")
// }

for (entry in jsonData) {
    val obj = entry as JsonObject

    println(obj)

    val arr = entry.get("people") as JsonArray<String>

    for (person in arr) {
        // val obj2 = person as JsonObject

        println(person)
    }
}