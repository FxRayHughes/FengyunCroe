package ray.mintcat.fengyuncroe.book

import io.izzel.taboolib.module.inject.TListener
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

@TListener
object JoinBookListener:Listener {

    @EventHandler
    fun onPlayerJoin(event:PlayerJoinEvent){
        val player = event.player
        BookUtil.openBook(player,"JoinBook")
    }

}