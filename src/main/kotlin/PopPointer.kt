class PopPointer(private val value: Int) : Command {
    override fun getAsmCommands(): List<String> {
        val pointerMap = mapOf(
            0 to "THIS",
            1 to "THAT"
        )
        val pointerValue: String = pointerMap[value]!!
        return listOf(
            "// pop pointer $value",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@$pointerValue",
            "M=D"
        )
    }
}