
object MessinWithScala {
import mws.csv_parsing.ColumnHandler
    def main(args: Array[String]) {
        val col = args.head
        val colHandler = ColumnHandler.fromString(col)
        var book = new Book
        handler.exec(book, args.last)
        Array(col, handler, book).foreach ( println(_) )
    }
}
