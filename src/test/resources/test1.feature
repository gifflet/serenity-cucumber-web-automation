Feature: Operação básica 1

@usrum
 Scenario Outline: Test1
  Given test iniciated 2 "<test_message>"
  Then test finished
Examples:
	| test_message		|
	|	java			|
	|	ruby			|