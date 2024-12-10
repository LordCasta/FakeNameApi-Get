#Automatización de petición Get

##Tecnologías usadas
Java, Serenity BDD, Gradle, Apache poi (para excel), patrón screenplay

##Explicación carpetas

En main, tenemos:
- Constants: URL base de la api
- Tasks: Tarea para la petición, con la estructura de la petición
- Utils: Herramientas que uso para poder traer los datos del excel e importarlos al feature
  
En test, tenemos:
- Runners: Encargados de traer los datos del excel y realizar los pasos del stepDefinitions
- StepDefinitions: Paso a paso declarado en el feature, y uso de el Task
- Features: Definición de el paso a paso, y datos a usar

##¿Qué se hace?
Se realiza una petición get al fakename api, que crea una "persona", con nombre, edad y correo, todo esto de forma aleatoria, lo que hace complejo un proceso de comprobar datos.
Adicional, al realizar la petición, comprobamos el codigo de estado 200 (correcto). No se valida nada más, debido a que genera un HTML como respuesta, no un JSON para comprobar.
