Scala Gherkin
===============

A simple Scala project. To run:

    sbt run

Backus-Naur Form representation of Gherkin
------------------------------------------

Thanks to Wikipedia for [this article](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_Form).

    feature ::= "Feature:" title description? scenario*
    scenario ::= "Scenario:" title given? when? then?
    given ::= "Given:" step and*
    when ::= "When:" step and*
    then ::= "Then:" step and*
    and ::= "(And|But):" step

    description ::= all-chars*
    title ::= all-chars*
    step ::= all-chars*

Note, 'all-chars' here indicates any line of text (that is all characters
except newline).

Some Gherkin keywords are currently not implemented, including:

* background
* scenario-outline
* examples

There is a full list of Gherkin keywords here: 
https://github.com/cucumber/cucumber/wiki/Feature-Introduction .

The Gherkin github repo has a BNF defined here:
https://github.com/cucumber/gherkin/wiki/BNF .
