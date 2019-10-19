## Herramientas

El proyecto se implementará en el lenguaje de programación Java, debido a que es uno de los lenguajes con los que más he practicado , mediante el uso del framework [Spring Boot](https://spring.io/projects/spring-boot).

Será necesario utilizar un broker de mensajes para gestionar la cola de tareas, en este caso se utilizará [RabbitMQ](https://www.rabbitmq.com/).

Como sistema de log (para conocer todo lo que ocurre en el servicio) se utilizará [Logstash](https://www.elastic.co/products/logstash).

No será necesario utilizar ninguna base de datos, pues en principio el objetivo de este servicio no es almacenar ninguna imagen o información.

