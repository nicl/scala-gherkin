package net.room271

import scala.util.parsing.combinator.RegexParsers

class GherkinParser extends RegexParsers {
  val charSeq = ".*".r
  val nonScenarioCharSeq = "[^(Scenario:)].*".r

  def feature: Parser[Feature] = "Feature:" ~> title ~ opt(description) ~ rep(scenario) ^^ {
    case title~description~scenarios => Feature(title, description, scenarios)
  }

  def scenario: Parser[Scenario] = "Scenario:" ~> title ~ opt(given) ~ opt(when) ~ opt(then) ^^ {
    case title~given~when~then => Scenario(title, List(given, when, then).flatMap(_.getOrElse(Nil)))
  }

  def given: Parser[List[Step]] = "Given:" ~> step ~ rep(and) ^^ {
    case step~ands => Given(step) :: (ands map Given)
  }

  def when: Parser[List[Step]] = "When:" ~> step ~ rep(and) ^^ {
    case step~ands => When(step) :: (ands map When)
  }

  def then: Parser[List[Step]] = "Then:" ~> step ~ rep(and) ^^ {
    case step~ands => Then(step) :: (ands map Then)
  }

  def and: Parser[String] = ("And:" | "But:") ~> step

  def description: Parser[String] = rep(nonScenarioCharSeq) ^^ {
    case description => description.mkString("\n")
  }

  def title: Parser[String] = charSeq

  def step: Parser[String] = charSeq
}