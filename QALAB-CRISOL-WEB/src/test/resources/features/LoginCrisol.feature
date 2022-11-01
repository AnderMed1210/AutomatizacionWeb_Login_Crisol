Feature: Login Crisol

  @Crisol
  Scenario: Inicio de Sesion en web de Crisol y validar nombre del usuario
    Given que estoy en la web de Crisol
    When ingreso con el correo "pruebasauto123456789@gmail.com"
    And ingreso con el password "PruebasAuto12345"
    And clic en el boton Iniciar Sesion
    Then validar el saludo "Hola, Anderson Cesar"
    And validar el telefono de la dirrecion "987456123"