package net.room271

import scala.util.parsing.combinator.RegexParsers

class GherkinParser extends RegexParsers {
  val charSeq = ".*".r
  val nonQuotedCharSeq = "[^(\"\"\")].*".r
  val nonScenarioCharSeq = "[^(Scenario:)].*".r

  def feature: Parser[Feature] = "Feature:" ~> title ~ opt(description) ~ rep(scenario) ^^ {
    case title~description~scenarios => Feature(title, description, scenarios)
  }

  def scenario: Parser[Scenario] = "Scenario:" ~> title ~ rep(step) ^^ {
    case title~steps => Scenario(title, steps)
  }

  def step: Parser[Step] = stepPrefix ~ charSeq ~ opt(textString) ^^ {
    case stepPrefix~text~textString => Step(stepPrefix, text, textString)
  }
  
  def title: Parser[String] = charSeq

  def description: Parser[String] = rep(nonScenarioCharSeq) ^^ (_.mkString("\n"))

  def stepPrefix: Parser[String] = ("Given" | "When" | "Then" | "And" | "But") <~ ":"

  def textString: Parser[String] = "\"\"\"" ~> rep(nonQuotedCharSeq) <~ "\"\"\"" ^^ (_.mkString("\n"))
}