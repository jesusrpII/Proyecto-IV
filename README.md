[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)[![Build Status](https://travis-ci.org/jesusrpII/Proyecto-IV.svg?branch=master)](https://travis-ci.org/jesusrpII/Proyecto-IV)



# Proyecto-IV
Proyecto que se va a desarrollar a lo largo de la asignatura de Infraestructura Virtual 2019-2020

## Microservicio
El servicio va a tratar de recibir unas imagenes y dado un factor de compresión, comprimir dichas imagenes (convertirlas en imagenes con menor peso,con mejor o peor calidad dependiendo de los parámetros que se indiquen).

El objetivo del servicio es aportar una solución rápida al usuario a la hora de ahorrar espacio en el almacenamiento de imagenes.

## Herramientas

El proyecto se implementará en el lenguaje de programación Java, debido a que es uno de los lenguajes con los que más he practicado , mediante el uso del framework [Spring Boot](https://spring.io/projects/spring-boot).

Será necesario utilizar un broker de mensajes para gestionar la cola de tareas, en este caso se utilizará [RabbitMQ](https://www.rabbitmq.com/).

Como sistema de log (para conocer todo lo que ocurre en el servicio) se utilizará [Logstash](https://www.elastic.co/products/logstash).

No será necesario utilizar ninguna base de datos, pues en principio el objetivo de este servicio no es almacenar ninguna imagen o información.

## Integración continua

Se ha enlazado el repositorio con Travis-Ci y creado el archivo .travis.yml con el contenido necesario para realizar los test.

Para la realización de los test se ha utilizado la biblioteca (en java) [junit4](https://junit.org/junit4/).

Para los pasos siguientes será necesario tener instalado maven (sudo apt-get install maven).

Se debera clonar o descargar el repositorio, una vez hecho eso nos situamos en la carpeta imageCo y ejecutamos mvn clean install. Inmediatamente se compilará el proyecto y ejecutaran los test.


