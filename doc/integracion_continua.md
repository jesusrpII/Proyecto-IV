## Integración continua (actualizada)

Para información acerca de los tests que se ejecutan: [Test] (https://github.com/jesusrpII/Proyecto-IV/tree/master/doc/test.md)


Se ha enlazado el repositorio con Travis-Ci y creado el archivo .travis.yml con el contenido necesario para realizar los tests.

```yaml

language: java   #Especificamos lenguaje
jdk:             # Y version de jdk
  -oraclejdk11
  

before_script:
  - cd imageCo
  - mvn clean

script:    # Indicamos la carpeta donde se situa el pom.xml y la compilacion y ejecución de los test con maven
  - mvn compile
  - mvn test                #Se ejecutan los tests



```

Adicionalmente se ha enlazado el repositorio con shippable y creado el archivo shippable.yml (es muy parecido al de travis):

```yaml
language: java   #Especificamos lenguaje
jdk:             # Y version de jdk
  - oraclejdk11
  
build:     # Indicamos la carpeta donde se situa el pom.xml y la compilacion y ejecución de los test con maven

  ci:
     - cd imageCo
     - mvn clean
     - mvn compile
     - mvn test      # Se ejecutan los test
```
