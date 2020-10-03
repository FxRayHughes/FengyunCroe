package ray.mintcat.fengyuncroe

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject

object FengyunCroe : Plugin() {

    @TInject(value = ["settings.yml"], locale = "LOCALE-PRIORITY")
    lateinit var settings: TConfig
        private set

    @TInject(value = ["books.yml"], locale = "LOCALE-PRIORITY")
    lateinit var books: TConfig
        private set


    override fun onLoad() {
        // override onLoad()
    }

    override fun onEnable() {
        // override onEnable()
    }

    override fun onDisable() {
        // override onDisable()
    }
}