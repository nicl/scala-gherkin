Scala Gherkin
===============

A simple Scala project. To run:

    sbt run

Backus-Naur Form representation of Gherkin
------------------------------------------

Thanks to Wikipedia for [this article](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_Form).

    feature ::= feature-title description? scenario*
    scenario ::= scenario-title given when then
    scenario-title ::= "Scenario:" title
    given ::= "Given:" step and*
    when ::= "When:" step and*
    then ::= "Then:" step and*
    and ::= "(And|But):" step

    description ::= all-chars description
    title ::= all-non-newline-chars title*
    step ::= all-non-newline-chars step*

Note, there is a list of Gherkin keywords here: 
https://github.com/cucumber/cucumber/wiki/Feature-Introduction .

I still need to add several, including:

* background
* scenario-outline
* examples

The Gherkin github repo has a BNF defined here:
https://github.com/cucumber/gherkin/wiki/BNF .

But I don't want to look at that yet! Better to struggle on my own first!
