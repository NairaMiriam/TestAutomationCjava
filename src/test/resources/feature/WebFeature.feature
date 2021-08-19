# new feature
# Tags: optional

Feature: A description

  @Id03
  Scenario Outline: buscar informacion
    Given carga la pagina web de google _01
    When ingresa el texto "<sTexto>" a buscar _01
    Then la aplicacion web de google realiza la busqueda del texto "<sTexto>" _01
    Examples:
      | sTexto   |
      | selenium |
      | cucumber |
      | java     |
      | facebook |