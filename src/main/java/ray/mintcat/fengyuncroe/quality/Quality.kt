package ray.mintcat.fengyuncroe.quality

import org.bukkit.entity.Player
import ray.mintcat.wizard.wizard.WizardObject
import java.util.logging.Logger

object Quality {

    /**
     * 这是所有物品的品质算法
     * 算法:
     * 1~80随即数 + 时间戳最后一位 + (运气[0~1] * 1 ~ 9) + UUID中第一个数字
     * */
    fun getQualityValue(player: Player):Int{

        val randoms = (0..80).random()
        val time = player.world.time.toString().substring(0,1).toInt()
        val luck = WizardObject.getIntegral(player,"luck",0) as Int
        val uuid = player.uniqueId.leastSignificantBits.toString()[0].toInt().toString().substring(0,1).toInt()
        val last = WizardObject.getIntegral(player,"last",0) as Int
        val value = randoms + time + (luck * (0..9).random() ) + uuid + last
        if (value < 100){
            WizardObject.addIntegral(player,"last",1)
        }else{
            WizardObject.setIntegral(player,"last",0)
        }
        return value
    }

    fun getQualityName(player: Player):String{
        val int = getQualityValue(player)
        if (int >= 100){
            return "极品"
        }else if (int >= 80){
            return "上品"
        }else if (int >= 50){
            return "中品"
        }else{
            return "下品"
        }
    }
}