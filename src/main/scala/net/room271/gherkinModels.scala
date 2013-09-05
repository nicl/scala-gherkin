package net.room271

case class Feature(
    title: String,
    description: Option[String],
    scenarios: List[Scenario])
    
case class Scenario(
    title: String,
    steps: List[Step])

case class Step(prefix: String, step: String, textString: Option[String])