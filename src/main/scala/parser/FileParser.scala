package parser

import item.{Apple, Banana, Item, Orange}

class FileParser {

  def parseFile(fileName: String): List[Item] = {
    val itemLog = scala.io.Source.fromFile(fileName)
    val items: List[Item] = {
      itemLog.getLines().toList.map {
        case "Apple"  => Apple
        case "Orange" => Orange
        case "Banana" => Banana
        case _        => throw new RuntimeException("Invalid item in basket")
      }
    }
    itemLog.close()
    items
  }
}
