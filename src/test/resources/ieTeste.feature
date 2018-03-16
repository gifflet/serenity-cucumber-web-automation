Feature: Testando no IE

@usrum
 Scenario Outline: pesquisa no google
  Given estou na pagina do google
  Then pesquise por kotlin
  
Examples:
	| n |
	| 1 |
	| 2 |