# new feature
# Tags: optional

Feature: Buscar informacion en google
  Yo como usuario
  Quiero realizar una búsqueda de selenium en google
  Para ver informacion actualizada de selenium

  @Google @Id01
  Scenario: buscar informacion de selenium
    Given carga la pagina web de google
    When ingresa el texto "selenium" a buscar
    Then la aplicacion web de google realiza la busqueda del texto "selenium"


  @Google @ID02 @HappyPath
  Scenario: buscar informacion de selenium
    Given carga la pagina web de google
    When ingresa el texto "selenium" a buscar
    Then la aplicacion web de google realiza la busqueda del texto "selenium"