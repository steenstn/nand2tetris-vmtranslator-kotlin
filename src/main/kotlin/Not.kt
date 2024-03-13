class Not: Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// neg",
            "@SP",
            "M=M-1",
            "A=M",
            "M=!M",
            "@SP",
            "M=M+1"
        )
    }
}