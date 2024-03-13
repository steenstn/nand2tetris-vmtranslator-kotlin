class LessThan : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// lt",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M-D",
            "@LESSTHAN$branchNum",
            "D;JLT",
            "@SP",
            "A=M",
            "M=0",
            "@LTCONT$branchNum",
            "0;JMP",
            "(LESSTHAN$branchNum)",
            "@SP",
            "A=M",
            "M=-1",
            "(LTCONT$branchNum)",
            "@SP",
            "M=M+1"
        ).also { branchNum++ }
    }
}