// Reading files from Groovy YEYEYEYEYEEEE

/** reading files **/

// to use file paths you must use forward / slashes instead of backslashes
String filePath = "C:/Users/Sharon Gabanakgosi/OneDrive - ?? ???????? ??????????/Desktop/GroovyUdemy/data.txt"
File myFile = new File(filePath)

// reading entire content as String
println myFile.text
println "\n"

// collect lines into a list
def list = myFile.collect{it}
println "list: ${list}"
println "\n"

// store file content in an array
def array = myFile as String[]
println "array: ${array}"
println "\n"

// read file into a list of String
def lines = myFile.readLines()
println "String: ${lines}"
println "\n"

// read file line by line
myFile.eachLine { line ->
    println "line : ${line}"
}
println "\n"

// read file line by line with line no
myFile.eachLine { line, lineNo ->
    println "${lineNo} : ${line}"
}
println "\n"

// read file line by line with line no & range
def lineNoRange = 2..4
def lineList = []
myFile.eachLine { line, lineNo ->
    if(lineNoRange.contains(lineNo)) {
        lineList.add(line)
    }
   // println "${lineNo} : ${line}"
}
println "lineList : ${lineList}"
println "\n"

// read with reader 
def line
myFile.withReader { reader ->
    while((line = reader.readLine()) != null ){
        println "line : ${line}"
    }
}
println "\n"

// read with new reader
def outputFile = "C:/Users/Sharon Gabanakgosi/OneDrive - ?? ???????? ??????????/Desktop/GroovyUdemy/data2.txt"
def reader = myFile.newReader()
new File(outputFile).append(reader)
reader.close()
println "\n"

// when working with binary files, read content as bytes
byte[] contents = myFile.bytes
println contents
println "\n"

// size of file in bytes
println myFile.length()
println "\n"

// check if file is a file or a directory
println myFile.isFile()
println myFile.isDirectory()
println "\n"

// get list of files from a directory
new File("C:/Users/Sharon Gabanakgosi/OneDrive - ?? ???????? ??????????/Desktop/GroovyUdemy").eachFile {
    files -> println files.getAbsolutePath()
}
println "\n"

// recursively display all files in a directory and it's subdirectory
new File("C:/Users/Sharon Gabanakgosi/OneDrive - ?? ???????? ??????????/Desktop/GroovyUdemy").eachFileRecurse {
    files -> println files.getAbsolutePath()
}
println "\n"

// copy file data to another file
def newFile = new File("C:/Users/Sharon Gabanakgosi/OneDrive - ?? ???????? ??????????/Desktop/GroovyUdemy/data3.txt")
newFile << myFile.text