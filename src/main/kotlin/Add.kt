class Add : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// add",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@SP",
            "M=M-1",
            "A=M",
            "M=M+D",
            "@SP",
            "M=M+1"
        )

    }
}