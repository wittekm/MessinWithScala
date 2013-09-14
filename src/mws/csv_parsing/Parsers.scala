package mws.csv_parsing

object Parsers {
    type Parser[T] = (String) => T

    val BoolParser = (str: String) => str.toBoolean
    val StringParser = (str: String) => str
}
