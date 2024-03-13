class Eq : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// eq",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@SP",
            "M=M-1",
            "A=M",
            "D=D-M",
            "@EQUAL$branchNum",
            "D;JEQ",
            "@SP",
            "A=M",
            "M=0",
            "@EQCONT$branchNum",
            "0;JMP",
            "(EQUAL$branchNum)",
            "@SP",
            "A=M",
            "M=-1",
            "(EQCONT$branchNum)",
            "@SP",
            "M=M+1"
        ).also { branchNum++ }

    }
}