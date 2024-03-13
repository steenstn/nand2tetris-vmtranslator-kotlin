import java.io.File


val commandMap = mapOf(
    "add" to Add(),
    "sub" to Sub(),
    "neg" to Neg(),
    "and" to And(),
    "or" to Or(),
    "not" to Not(),
    "eq" to Eq(),
    "lt" to LessThan(),
    "gt" to GreaterThan()
)

var branchNum = 0

val path ="/home/steen/nand2tetris/projects/07/MemoryAccess/StaticTest/"
val fileName = "StaticTest"
val inputFile = "$path$fileName.vm"

fun main(args: Array<String>) {
    val outputFile = inputFile.replace(".vm", ".asm")

    File(outputFile).delete()
    val list = File(inputFile).readLines()
    list.forEach { line ->
        if (line.startsWith("//") || line.isBlank()) {
            return@forEach
        }
        val tokens = line.split(" ")

        val command = if (tokens.size == 1) {
            commandMap[tokens.first()] ?: throw Exception("Missing command for ${tokens.first()}")
        } else {
            getPPCommand(tokens)
        }

        command.getAsmCommands().forEach { c ->
            println(c)
            File(outputFile).appendText(c)
            File(outputFile).appendText("\n")
        }

    }
}

fun getPPCommand(tokens: List<String>): Command {
    if (tokens[0] == "push" && tokens[1] == "constant") {
        return PushConstant(Integer.parseInt(tokens[2]))
    }
    if(tokens[0] == "push" && tokens[1] == "static") {
        return PushStatic(Integer.parseInt(tokens[2]), fileName)
    }
    if(tokens[0] == "pop" && tokens[1] == "static") {
        return PopStatic(Integer.parseInt(tokens[2]), fileName)
    }
    if(tokens[0] == "push" && tokens[1] == "pointer") {
        return PushPointer(Integer.parseInt(tokens[2]))
    }
    if(tokens[0] == "pop" && tokens[1] == "pointer") {
        return PopPointer(Integer.parseInt(tokens[2]))
    }
    if(tokens[0] == "push" && tokens[1] == "temp") {
        return PushTemp(Integer.parseInt(tokens[2]))
    }
    if(tokens[0] == "pop" && tokens[1] == "temp") {
        return PopTemp(Integer.parseInt(tokens[2]))
    }

    if (tokens[0] == "push") {
        return Push(tokens[1], Integer.parseInt(tokens[2]))
    }
    if (tokens[0] == "pop") {
        return Pop(tokens[1], Integer.parseInt(tokens[2]))
    }
    return NoOp()
}
