package ray.mintcat.fengyuncroe.book

import io.izzel.taboolib.TabooLibAPI
import io.izzel.taboolib.util.book.BookFormatter
import io.izzel.taboolib.util.book.builder.PageBuilder
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import ray.mintcat.fengyuncroe.FengyunCroe


object BookUtil {
    /**
     * 将多行内容创建为成书
     * 会根据行数自动翻页，但不会自动换行
     * Form Cronus Bkm016 Thinks
     */
    fun toBookItem(lines: List<String>): ItemStack {
        val bookBuilder = BookFormatter.writtenBook()
        var builder: PageBuilder? = null
        var index = 0
        for (line in lines) {
            if (builder == null) {
                builder = PageBuilder()
            }
            builder.add(line).newLine()
            if (index++ == 13) {
                bookBuilder.addPages(builder.build())
                builder = null
                index = 0
            }
        }
        if (builder != null) {
            bookBuilder.addPages(builder.build())
        }
        return bookBuilder.build()
    }

    fun getBook(id:String,player:Player) : List<String>{
        val bookInfo = FengyunCroe.books.getStringListColored(id)
        return TabooLibAPI.getPluginBridge().setPlaceholders(player,bookInfo)
    }

    fun getBook(id:String) : List<String>{
        val bookInfo = FengyunCroe.books.getStringListColored(id)
        return bookInfo
    }

    fun openBook(player: Player,id: String){
        val book = toBookItem(getBook(id,player))
        BookFormatter.forceOpen(player,book)
    }

}