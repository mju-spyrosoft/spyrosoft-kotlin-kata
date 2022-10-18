package _4_delegation

import java.io.File
import java.io.IOException
import java.nio.file.Files


class DataFileMetadata(private val file: File) {

    val contents: String = ""
}

fun main(){
    val newFile = File("FileMetadata.txt")
    newFile.createNewFile()

    val dataFileMetadata = DataFileMetadata(newFile)
    dataFileMetadata.contents
    dataFileMetadata.contents
    dataFileMetadata.contents
}
