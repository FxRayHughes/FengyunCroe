package ray.mintcat.fengyuncroe.quality

import io.izzel.taboolib.module.inject.THook
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.entity.Player

@THook
class QualityPAPI: PlaceholderExpansion() {

    override fun getIdentifier(): String {
        return "quality"
    }
    override fun getAuthor(): String {
        return "枫溪"
    }
    override fun getVersion(): String {
        return "1.0.0"
    }
    override fun persist(): Boolean {
        return true
    }

    override fun onPlaceholderRequest(player: Player?, params: String): String {
        if (player == null || !player.isOnline) {
            return "N/A"
        }
        val param = params.split("_")
        return when (param[0]) {
            "get" -> Quality.getQualityValue(player).toString()
            "name" -> Quality.getQualityName(player)
            else -> "N/A"
        }
    }
}