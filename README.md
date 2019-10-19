[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)[![Build Status](https://travis-ci.org/jesusrpII/Proyecto-IV.svg?branch=master)](https://travis-ci.org/jesusrpII/Proyecto-IV) [![Run Status](https://api.shippable.com/projects/5daaf6a47e25c60006d54718/badge?branch=master)]() 



# Proyecto-IV
Proyecto que se va a desarrollar a lo largo de la asignatura de Infraestructura Virtual 2019-2020

## Microservicio
El servicio va a tratar de recibir unas imagenes y dado un factor de compresión, comprimir dichas imagenes (convertirlas en imagenes con menor peso,con mejor o peor calidad dependiendo de los parámetros que se indiquen).

El objetivo del servicio es aportar una solución rápida al usuario a la hora de ahorrar espacio en el almacenamiento de imagenes.


## Integración continua

Para la realización de los test se ha utilizado la biblioteca (en java) [junit4](https://junit.org/junit4/).

Se ha enlazado el repositorio con Travis-Ci y creado el archivo .travis.yml con el contenido necesario para realizar los test.

```yaml

language: java   #Especificamos lenguaje
jdk:             # Y version de jdk
  -oraclejdk11
  
script:              # Indicamos la carpeta donde se situa el pom.xml y la compilacion y ejecución de los test con maven
  - cd imageCo
  - mvn clean install

```

Adicionalmente se ha enlazado el repositorio con shippable y creado el archivo shippable.yml (es muy parecido al de travis):

```yaml
language: java   #Especificamos lenguaje
jdk:             # Y version de jdk
  - oraclejdk11
  
build:     # Indicamos la carpeta donde se situa el pom.xml y la compilacion y ejecución de los test con maven
  ci:
     - cd imageCo
     - mvn clean install
```


### Clonar repositorio y probar los test

Para los pasos siguientes será necesario tener instalado maven (sudo apt-get install maven).

Se debera clonar o descargar el repositorio, una vez hecho eso nos situamos en la carpeta imageCo (cd imageCo) y ejecutamos mvn clean install. Inmediatamente se compilará el proyecto y ejecutaran los test.


### Información adicional

[Herramientas a utilizar](https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/herramientas.md)

