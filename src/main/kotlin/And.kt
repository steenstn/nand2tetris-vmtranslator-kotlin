class And : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// and",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@SP",
            "M=M-1",
            "A=M",
            "M=D&M",
            "@SP",
            "M=M+1"
        )
    }
}