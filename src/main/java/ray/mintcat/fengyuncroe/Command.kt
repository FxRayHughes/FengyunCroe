package ray.mintcat.fengyuncroe

import io.izzel.taboolib.module.command.base.*
import io.izzel.taboolib.module.tellraw.TellrawJson
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import ray.mintcat.fengyuncroe.book.BookUtil
import ray.mintcat.wizard.Wizard

@BaseCommand(name = "fengyun", aliases = ["fy"], permission = "*")
class Command : BaseMainCommand() {
    override fun getCommandTitle(): String {
        return ""
    }

    @SubCommand
    var item: BaseSubCommand = object : BaseSubCommand() {
        override fun getDescription(): String {
            return "获取物品信息"
        }

        override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>) {
            val player = sender as Player
            val itemStack = player.inventory.itemInMainHand ?: return
            sender.sendMessage(" ")
            TellrawJson.create()
                    .append("§7[§aFengyunCore§7]§f " + "§7物品的 Material: §f" + itemStack.type)
                    .clickSuggest(itemStack.type.toString())
                    .hoverText("点击复制到聊天框")
                    .send(sender)
            TellrawJson.create()
                    .append("§7[§aFengyunCore§7]§f " + "§7物品的 ItemStack: §f" + itemStack)
                    .clickSuggest(itemStack.toString())
                    .hoverText("点击复制到聊天框")
                    .send(sender)
            }
        }

    @SubCommand
    var book: BaseSubCommand = object : BaseSubCommand() {
        override fun getDescription(): String {
            return "打开书本"
        }
        override fun getArguments(): Array<Argument> {
            return arrayOf(Argument("目标"), Argument("书本编号"))
        }

        override fun onCommand(sender: CommandSender, command: Command, s: String, args: Array<String>) {
            val player = Bukkit.getPlayerExact(args[0])
            if (player == null) {
                sender.sendMessage(Wizard.getTitle() + "§7目标 §f" + args[0] + " §7离线.")
                return
            }
            BookUtil.openBook(player,args[1])
        }
    }
    }