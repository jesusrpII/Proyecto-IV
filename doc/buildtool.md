### Herramienta de construcción

Como herramienta de construcción se a utilizado [Maven](https://maven.apache.org/). 
Maven es una herramienta de construcción open source que se encarga de compilar y generar los ejecutables de nuestro proyecto. 
Se ha elegido ya que es una herramienta facil de instalar y utilizar. 
"apt-get install maven" (para instalar) y "mvn archetype:generate" (que puede ir junto a otros parametros para generar la estructura de nuestro proyecto)

En mi caso para esta fase del proyecto he utilizado el IDE Netbeans con lo cual el proceso ha sido incluso más sencillo, de hecho el fichero de dependencias pom.xml se genera solo y se actualiza al añadir nuevas librerías (por ejemplo al añadir junit), de no hacerlo se deberían añadir las dependencias manualmente.

Toda la información necesaria para construir el proyecto se encuentra en el archivo pom.xml que ya se ha comentado anteriormente (se ha generado automáticamente) contiene todas las dependencias, así como otra información como puede ser el groupID o artifactId entre otras:

```yaml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>JRP</groupId>
    <artifactId>proyectoIV</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
            <type>jar</type>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.5</version>
            <type>jar</type>
        </dependency>
    </dependencies>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
</project>
```


Una vez tenemos nuestro proyecto implementado y el pom.xml anterior basta con ejecutar "mvn clean install" (por supuesto, situados en el directorio que contiene nuestro proyecto) y se compilara  el proyecto y ejecutaran los test.

Con "mvn test" se ejecutarán los test.

