# new feature
# Tags: optional

Feature: A description

  @Id20
  Scenario Outline: buscar informacion por ambiente
    Given carga la pagina web de google _web
    When ingresa el texto "<sTexto>" a buscar _web
    Then la aplicacion web de google realiza la busqueda del texto "<sTexto>" _web
    Examples:
      | sTexto   |
      | selenium |
      #| cucumber |
      #| java     |
      #| facebook |