# Proyecto-IV
Proyecto que se va a desarrollar a lo largo de la asignatura de Infraestructura Virtual

## Servicio
El servicio va a tratar de recibir unas imagenes y dado un factor de compresión, comprimir dichas imagenes (convertirlas en imágenes con menor peso,con mejor o peor calidad dependiendo de los parámetros que se indiquen).

El objetivo del servicio es aportar una solución rápida al usuario a la hora de ahorrar espacio en el almacenamiento.

## Herramientas

El proyecto se implementará en el lenguaje de programación Java (es uno de los lenguajes con los que mas he trabajado) , mediante el uso del framework Spring Boot.

Será necesario utilizar un broker de mensajes para gestionar la cola de tareas, en este caso se utilizará RabbitMQ.

Como sistema de log (para conocer todo lo que ocurre en el microservicio) se utilizará Logstash.

No será necesario utilizar ninguna base de datos, pues en principio el objetivo de este servicio no es almacenar ninguna imágen o información.


