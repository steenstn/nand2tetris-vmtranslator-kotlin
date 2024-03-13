class Push(private val segment: String, private val value: Int) : Command {
    override fun getAsmCommands(): List<String> {
        // push local i => addr = LCL+i; *SP = *addr; SP++
        return listOf(
            "// push $segment $value",
            // addr = LCL+i
            "@$value",
            "D=A",
            "@${addressMap[segment]}",// A = 1
            "A=M+D",
            "D=M",

            // *SP = *addr
            "@SP",
            "A=M",
            "M=D",

            // SP++
            "@SP",
            "M=M+1"
        )

        /*
        @2
        D=A // D = 2
        @LCL // A = 1
        A=M+D // A = 10+2 = 12
        D=M // D=RAM[12]
        @SP // A = 0
        A=M // A = 257
        M=D // RAM[257] = RAM[12]

         */


    }
}