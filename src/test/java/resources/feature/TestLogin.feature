# new feature
# Tags: optional
Feature: Ingreso al Sistema
  Yo como Usuario
  Quiero Ingresar al sistema
  Para poder hacer uso de las funcionalidades

  Background:
    Given se encuentra en el login del sistema

  Scenario:Login - verificar el ingreso al sistema exitoso
    And se encuentra registrado en el sistema
    When ingresa usuario "naira" correcto
    And ingresa contraseña "password" correcto
    And clickea en el boton ingresar
    Then el sistema permitira el ingreso correctamente

  Scenario: Login - verificar el ingreso al sistema con usuario invalido
    And no se encuentra registrado en el sistema
    When ingreso un usuario "naira" incorrecto
    And ingreso contraseña "password" incorrecto
    And clickea en el boton ingresar
    Then el sistema no permite el ingreso
    And muestra un mensaje indicando "usuario o contraseña son incorrectos"


  Scenario: Login - verificar el ingreso al sistema con contraseña incorrecto
    And se encuentra registrado en el sistema
    When ingreso el usuario "naira" correcto
    And ingresa contraseña "password" incorrecto
    And clickea en el boton ingresar
    Then el sistema no permite el ingreso
    And muestra un mensaje indicando "usuario o contraseña son incorrectos"

  Scenario: Login - verificar sesion expirada del usuario
    And dejo inactivo por 10 minutos
    When la sesion haya expirado
    Then el sistema no permite realizar ninguna operacion
    And el sistema redirecciona al Login


  Scenario Outline: Login - verificar el ingreso al sistema exitoso
    And se encuentra registrado en el sistema
    When ingresa usuario "<sUser>" correcto
    And ingresa contraseña "<sPassword>" correcto
    And clickea en el boton ingresar
    Then el sistema permitira el ingreso correctamente mostrando un "<sMensaje>"
    Examples:
      | sUser | sPassword | sMensaje                             |
      | Naira | Admin123  | Ingreso Exitoso                      |
      | Benyi | Admin123  | usuario o contraseña son incorrectos |
      |       |           | ingrese los datos correctos          |

  Scenario: Registro Formulario - verificar el regristro de un usuario
    Given se encuentra en el formulario del sistema
    When ingreso los datos del usario en el formulario
      | Nombre | Apellido   | direccion | telefono    |
      | Maria  | De la Cruz | Lima      | 999 555 999 |
    And ckickeo en registrar
    Then el sistema muestra un mensaje de "registro exitoso"

  Scenario: Registro Formulario - verificar el regristro de un usuario
    Given se encuentra en el formulario del sistema
    When ingreso los datos del usario en el formulario
    And ckickeo en registrar
    Then el sistema muestra un mensaje de "registro exitoso"