package net.room271

import scala.util.parsing.combinator.RegexParsers

class GherkinParser extends RegexParsers {
  val charSeq = ".*".r
  val nonScenarioCharSeq = "[^(Scenario:)].*".r

  def feature: Parser[Any] = "Feature:" ~ title ~ opt(description) ~ rep(scenario)

  def scenario: Parser[Any] = "Scenario:" ~ title ~ opt(given) ~ opt(when) ~ opt(then)

  def given: Parser[Any] = "Given:" ~ step ~ rep(and)

  def when: Parser[Any] = "When:" ~ step ~ rep(and)

  def then: Parser[Any] = "Then:" ~ step ~ rep(and)

  def and: Parser[Any] = ("And:" | "But:") ~ step

  def description: Parser[Any] = rep(nonScenarioCharSeq)

  def title: Parser[Any] = charSeq

  def step: Parser[Any] = charSeq
}