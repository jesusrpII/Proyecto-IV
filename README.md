[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)[![Build Status](https://travis-ci.org/jesusrpII/Proyecto-IV.svg?branch=master)](https://travis-ci.org/jesusrpII/Proyecto-IV) [![Run Status](https://api.shippable.com/projects/5daaf6a47e25c60006d54718/badge?branch=master)]() 



# Proyecto-IV
Proyecto que se va a desarrollar a lo largo de la asignatura de Infraestructura Virtual 2019-2020

## Microservicio
El servicio va a tratar de recibir unas imagenes y dado un factor de compresión, comprimir dichas imagenes (convertirlas en imagenes con menor peso,con mejor o peor calidad dependiendo de los parámetros que se indiquen).

El objetivo del servicio es aportar una solución rápida al usuario a la hora de ahorrar espacio en el almacenamiento de imagenes.


### Clonar repositorio y ejecutar la aplicación spring boot

Para los pasos siguientes será necesario tener instalado maven (sudo apt-get install maven).

Se debera clonar o descargar el repositorio, una vez hecho eso nos situamos en la carpeta imageCo (cd imageCo) y ejecutamos mvn clean install. Inmediatamente se compilará el proyecto y ejecutaran los tests.

Para ejecutar la aplicación bastará con ejecutar mvn spring-boot:start y para pararlo mvn spring-boot:stop

Para más información:

[Herramienta de construcción: Maven](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/buildtool.md)  (Actualizado)

buildtool: pom.xml

### Despliegue en heroku

Despliegue: https://imageco.herokuapp.com/

- [Cómo se ha desplegado el proyecto en heroku](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/despliegue.md)

### Contenedor con Docker, uso de DockerHub y despliegue en azure

DockerHub: https://hub.docker.com/r/jesusrpii/proyectoiv

Contenedor: https://proyectoivdocker.azurewebsites.net/

- [Cómo se ha creado y desplegado en contenedor utilizando Docker](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/docker.md)

### Información adicional

- [Herramientas a utilizar](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/herramientas.md)

- [Integración Continua](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/integracion_continua.md)

### API

- [Información sobre la API](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/api.md)

- [Test](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/test.md)


