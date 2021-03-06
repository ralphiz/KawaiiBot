package me.alexflipnote.kawaiibot.commands

import me.alexflipnote.kawaiibot.extensions.closing
import me.alexflipnote.kawaiibot.extensions.json
import me.alexflipnote.kawaiibot.extensions.thenException
import me.alexflipnote.kawaiibot.utils.RequestUtil
import me.aurieh.ichigo.core.CommandContext
import me.aurieh.ichigo.core.ICommand
import me.aurieh.ichigo.core.annotations.Command

@Command(description = "Lovely coffee images")
class Coffee : ICommand {
    override fun run(ctx: CommandContext) {
        RequestUtil.get("https://coffee.alexflipnote.dev/random.json").thenAccept {
            val res = it.json()?.getString("file") ?: "I couldn't find any coffee ;-;'"
            ctx.send(res)
        }.thenException {
            ctx.send("I-I couldn't find any coffee... I'm sorry ;-;")
        }
    }
}
