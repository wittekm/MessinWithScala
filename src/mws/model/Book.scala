package mws.model

class Book {
    var title: Option[String] = None
    var language: Option[String] = None
    var version: Option[Integer] = None
    var isAdult: Option[Boolean] = None

    // TODO is there a better way to generate nice toStrings based on properties?
    override def toString:String = s"title: ${title} lang: ${language} isAdult: ${isAdult}"
}

object Book {
    // i missed you too typedefs
    type Setter[T] = Option[T] => Unit
}
