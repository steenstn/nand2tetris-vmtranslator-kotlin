class PopStatic(private val value: Int, private val fileName: String) : Command {
    override fun getAsmCommands(): List<String> {
        return listOf(
            /*
            ta värdet i SP, stoppa in det i @Xxx.i

            SP--
            @Xxx.i = *SP

             */
            "// pop static $value",
            "@SP",
            "M=M-1",
            "A=M",
            "D=M",
            "@$fileName.$value",
            "M=D"
        )
    }
}