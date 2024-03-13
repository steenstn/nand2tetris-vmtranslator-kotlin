interface Command {

    val addressMap: Map<String, String>
        get() = mapOf(
            "local" to "LCL",
            "argument" to "ARG",
            "this" to "THIS",
            "that" to "THAT",
            "temp" to "5" // Temp starts at RAM[5]
            )

    fun getAsmCommands(): List<String>
}