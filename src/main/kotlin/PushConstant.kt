class PushConstant(val value: Int) : Command {
    /*
    *SP = value // put value into the address that SP points at
     SP++ // Add 1 to SP
    */
    override fun getAsmCommands(): List<String> {
        return listOf(
            "// push constant $value",
            "@$value", // D=17
            "D=A",
            "@SP", // *SP=D
            "A=M",
            "M=D",
            "@SP", // SP++
            "M=M+1"
        )
    }
}