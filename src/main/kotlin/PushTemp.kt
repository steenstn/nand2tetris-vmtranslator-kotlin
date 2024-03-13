class PushTemp(private val value: Int) : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// push temp $value",
            "@${5 + value}",
            "D=M",

            "@SP",
            "A=M",
            "M=D",

            // SP++
            "@SP",
            "M=M+1"
        )
    }
}