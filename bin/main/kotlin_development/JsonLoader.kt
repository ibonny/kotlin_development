package kotlin_development

/*
import com.beust.klaxon.*

import java.io.StringReader
import java.util.regex.Pattern

import khttp.get


data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: String,
    val phone: String,
    val website: String,
    val company: Company
)

val pm = object: PathMatcher {
    override fun pathMatches(path: String) = Pattern.matches(".*name", path)

    override fun onMatch(path: String, value: Any) {
        println("Found ${value} at ${path}.")
    }
}

fun testLoadingJson() {
    val r = get("http://jsonplaceholder.typicode.com/users")

    val result = Klaxon()
        .pathMatcher(pm)
        .parseArray<User>(StringReader(r.text))

    println(result)
}
*/
