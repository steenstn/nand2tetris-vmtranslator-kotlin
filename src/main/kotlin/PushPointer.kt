class PushPointer(private val value: Int) : Command {
    override fun getAsmCommands(): List<String> {
        val pointerMap = mapOf(
            0 to "THIS",
            1 to "THAT"
        )
        val pointerValue: String = pointerMap[value]!!
        return listOf(
            "// push pointer $value",
            "@$pointerValue",
            "D=M",
            "@SP", // *SP=D
            "A=M",
            "M=D",
            "@SP", // SP++
            "M=M+1"
        )
    }
}