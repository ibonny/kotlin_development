package kotlin_development

import krangl.*

import com.beust.klaxon.Parser

import java.io.StringReader
import java.io.BufferedReader

import java.util.concurrent.TimeUnit
import java.io.IOException


fun String.runCommand(str: String): String? {
    try {
        val parts = this.split("\\s".toRegex())

        val proc = ProcessBuilder(*parts.toTypedArray())
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        proc.outputStream.writer(Charsets.UTF_8).use {
            it.write(str)
        }

        proc.waitFor(60, TimeUnit.MINUTES)

        return proc.inputStream.bufferedReader().readText()
    } catch(e: IOException) {
        e.printStackTrace()

        return null
    }
}


class Trial2() {
    fun myTrial() {
        val str = """
import pandas as pd

df = pd.read_hdf("testout.hdf5")

print(df.to_json(orient="records"))
        """

        val result = "python".runCommand(str)

        val df = DataFrame.fromJsonString(result!!)

        println(df)
    }
}
