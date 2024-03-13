class Pop(private val segment: String, private val value: Int) : Command {
    override fun getAsmCommands(): List<String> {
        // pop local i => addr = LCL + i; SP--; *addr = *SP
        return listOf(
            "// pop $segment $value",
            // addr = segment + i
            "@$value",
            "D=A",
            "@${addressMap[segment]}",
            "D=D+M",
            "@R13",
            "M=D",

            // *SP++
            "@SP",
            "M=M-1",

            // *addr = *SP
            "A=M",
            "D=M",
            "@R13",
            "A=M",
            "M=D"
        )

    }
}