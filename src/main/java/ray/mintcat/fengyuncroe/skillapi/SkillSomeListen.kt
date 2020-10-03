package ray.mintcat.fengyuncroe.skillapi

import com.sucy.skill.SkillAPI
import com.sucy.skill.api.util.FlagData
import io.izzel.taboolib.common.event.PlayerJumpEvent
import io.izzel.taboolib.module.inject.TInject
import io.izzel.taboolib.module.inject.TListener
import io.izzel.taboolib.util.lite.cooldown.Cooldown
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import ray.mintcat.fengyuncroe.FengyunCroe
import java.util.*
import java.util.concurrent.ConcurrentHashMap


@TListener
class SkillSomeListen : Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    fun onPlayerNoJump(event: PlayerJumpEvent) {
        val entity = event.player as LivingEntity
        if (FlagData(entity).hasFlag("NoJump")) {
            event.isCancelled = true
        }
    }
}