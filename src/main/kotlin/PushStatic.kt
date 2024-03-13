class PushStatic(private val value: Int, private val fileName: String) : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// push static $value",
            "@$fileName.$value",
            "D=M",
            "@SP",
            "A=M",
            "M=D",
            "@SP",
            "M=M+1"
        )
    }
}