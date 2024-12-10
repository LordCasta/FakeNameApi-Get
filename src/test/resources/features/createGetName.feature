#language: es

Característica: Automatizar peticion get de api fakename

  @Get

  Esquema del escenario: Peticion get exitosa

    Cuando Envio peticion al api con el genero "<genero>" localidad "<localidad>"
    Entonces Valido el codigo de respuesta "<codigo>"

    Ejemplos:
     | genero | localidad  | codigo |
     ##@externaldata@parametros/Datos.xlsx@api
   |/male   |/english-united-states   |200|

