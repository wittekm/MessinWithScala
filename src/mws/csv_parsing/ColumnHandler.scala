package mws.csv_parsing

abstract class ColumnHandler {
    def exec(book: Book, value: String)
}

object ColumnHandler {
    // TODO write a macro to replace manual book.isAdult_= stuff with "#{columnName}_=" - think compile-time version of ruby send(:method)
    def fromString(columnName: String): BaseColumnHandler = {
        columnName match {
            case "title"    => ColumnHandlerImpl("title",    Parsers.StringParser, _.title_= )
            case "language" => ColumnHandlerImpl("language", Parsers.StringParser, _.language_= )
            case "isAdult"  => ColumnHandlerImpl("isAdult",  Parsers.BoolParser,   _.isAdult_= )
            case _          => null
        }
    }
}

case class ColumnHandlerImpl[T](val columnName: String, val parser: Parser[T], val setter: (Book) => Book.Setter[T]) extends BaseColumnHandler {
    def exec(book: Book, value: String) = {
        val parsedVal = this.parser(value)
        setter(book)(Option(parsedVal))
    }
}
