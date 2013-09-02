package net.room271

case class Feature(
    title: String,
    description: Option[String],
    scenarios: List[Scenario])
    
case class Scenario(
    title: String,
    steps: List[Step])

sealed abstract class Step { val step: String }
case class Given(step: String) extends Step
case class When(step: String) extends Step
case class Then(step: String) extends Step