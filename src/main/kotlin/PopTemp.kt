class PopTemp(private val value: Int) : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// pop temp $value",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@${5 + value}",
            "M=D",
        )
    }
}