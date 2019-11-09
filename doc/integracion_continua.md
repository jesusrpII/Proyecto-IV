## Integración continua (hito2)

Para la realización de los test se ha utilizado la biblioteca (en java) [junit4](https://junit.org/junit4/).

Se han escrito 2 test que comprueban funciones básicas para el proyecto, en concreto se comprueba que se cargan las imagenes y leen valores como la extensión correctamente. En otro test se comprueba una función de compresión básica, para esta compresión se ha utilizado la clase de java ImageWriter.



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
