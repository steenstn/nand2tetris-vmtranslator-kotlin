class NoOp : Command {
    override fun getAsmCommands(): List<String> {
        return listOf("// NoOp")
    }
}