class GreaterThan: Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// gt",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M-D",
            "@GREATERTHAN$branchNum",
            "D;JGT",
            "@SP",
            "A=M",
            "M=0",
            "@GTCONT$branchNum",
            "0;JMP",
            "(GREATERTHAN$branchNum)",
            "@SP",
            "A=M",
            "M=-1",
            "(GTCONT$branchNum)",
            "@SP",
            "M=M+1"
        ).also { branchNum++ }

    }
}