# new feature
# Tags: optional

Feature: Buscar informacion en google
  Yo como usuario
  Quiero realizar una búsqueda de selenium en google
  Para ver informacion actualizada de selenium

  @Id01
  Scenario: buscar informacion de selenium
    Given carga la pagina web de google
    When ingresa el texto "selenium" a buscar
    Then la aplicacion web de google realiza la busqueda del texto "selenium"

  @Id03
  Scenario Outline: buscar informacion
    Given carga la pagina web de google
    When ingresa el texto "<sTexto>" a buscar
    Then la aplicacion web de google realiza la busqueda del texto "<sTexto>"
    Examples:
      | sTexto   |
      | selenium |
      | cucumber |
      | java     |
      | facebook |


  @Id01
  Scenario Outline: Seleccioar pais
    Given carga la pagina web de AirPort
    When seleciona el pais "<sPais>"
    #Then la aplicacion web de google realiza la busqueda del texto "selenium"
    Examples:
      | sPais |
      | Peru  |

  @Google @ID02 @HappyPath
  Scenario: buscar informacion de selenium09
    Given carga la pagina web de google
    When ingresa el texto "selenium" a buscar
    Then la aplicacion web de google realiza la busqueda del texto "selenium"