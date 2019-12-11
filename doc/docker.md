## Creación de contenedor Docker y uso de DockerHub

###Crear y lanzar contenedor Docker en local

Para la creación de un contenedor docker es necesario crear la imagen, para ello se ha utilizado un archivo de configuración Dockerfile:

```yaml
FROM maven:3.6-jdk-8 AS build
COPY imageCo/src /imageCo/src
COPY imageCo/pom.xml /imageCo
WORKDIR imageCo
EXPOSE 8080
CMD mvn spring-boot:run
```


Una vez creado el archivo anterior (situado en la raíz de nuestro proyecto):

-Creamos la imagen con "docker build -t imageco ."
(podemos comprobar que se ha generado la imagen "imageco" con "docker images", nos debería aparecer en la lista"

-Lanzamos el contenedor con "docker run -d --name imageco -p 8080:8080 imageco"

Tras desplegar el contenedor (podemos comprobar que se esta ejecutando con "docker ps"), podemos dirigirnos a "http://localhost:8080/" y nos debe aparecer el servicio.

#### Automatización con dockerHub

Antes de nada es necesario registrarse en dockerHub. 
Para hacer uso de la imagen de nuestro proyecto desde DockerHub y que esta imagen sea creada automáticamente cada vez que hagamos un push a nuestro repositorio de github:

-Enlazamos nuestra cuenta en dockerHub con nuestra cuenta en github.
![Imagen1](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/dockerHub1.png)
-Creamos un nuevo repositorio y lo enlazamos con nuestro repositorio de github.
![Imagen1](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/dockerHub2.png)



