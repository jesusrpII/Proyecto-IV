## Creación de contenedor Docker y uso de DockerHub

### Creación de contenedor Docker

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

- Creamos la imagen con "docker build -t imageco ." 
Podemos comprobar que se ha generado la imagen "imageco" con "docker images" (nos debería aparecer en la lista).

- Lanzamos el contenedor con "docker run -d --name imageco -p 8080:8080 imageco"

Tras desplegar el contenedor (podemos comprobar que se esta ejecutando con "docker ps"), podemos dirigirnos a "http://localhost:8080/" y nos debe aparecer el servicio.

### Automatización con dockerHub

Antes de nada es necesario registrarse en dockerHub. 
Para hacer uso de la imagen de nuestro proyecto desde DockerHub y que esta imagen sea actualizada automáticamente cada vez que hagamos un push a nuestro repositorio de github:

- Enlazamos nuestra cuenta en dockerHub con nuestra cuenta en github.
![Imagen1](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/dockerHub1.png)
- Creamos un nuevo repositorio y lo enlazamos con nuestro repositorio de github.
![Imagen2](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/dockerHub2.png)



### Despliegue del contenedor en Azure

Aprovechando que poseo la licencia de estudiante para Azure haré empleo de esta plataforma para desplegar el contenedor, el proceso es más sencillo de lo que esperaba si enlazamos dockerHub con Azure.

- Creamos la app desde Apps Services 

![Imagen3](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/azure1.png)

![Imagen4](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/azure2.png)

pero le indicamos que es un contenedor.

- Una vez creada, nos vamos a su configuración y en la pestaña Docker indicamos que la imagen del contenedor se encuentra en DockerHub y le indicamos en que repositori ode DockerHub se encuentra.

![Imagen5](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/azure3.png)

- Tras lo anterior Azure nos despliega correctamente el contenedor y podemos acceder al servicio, solo falta activar Continuous Deployment para que se actualice el servicio cada vez que modifiquemos la imagen haciendo push en nuestro repositorio de github (en ningún momento se ha asociado azure a github, pero recuerdo que más arriba se ha enlazado DockerHub con github). Para activar la opción se accede a la configuración del contenedor de azure como la siguiente imagen:

![Imagen5](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/azure4.png)


Contenedor desplegado en azure : https://proyectoivdocker.azurewebsites.net


### Despliegue del contenedor en Heroku (No funciona)

El despliegue en heroku de un contenedor no es muy diferente al despliegue que se ha hecho previamente del proyecto ([Documentación del despligue anterior](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/despliegue.md).

Para hacerlo se ha seguido los siguientes pasos:

- Teniendo ya la cuenta creada, hacemos "heroku login" (Para enlazar nuestra sesión en heroku)
- Tras ello creamos un nuevo recurso con "heroku create imageco-docker" (Se crear el repositorio que alojará el contenedor y se crea un repositorio remoto heroku en nuestro repositorio local)
- Hasta ahora todo a sido igual que en el anterior despliegue, pero en este caso será necesario añadir un archivo heroku.yml con:
```yaml
build:
  docker:
    web: Dockerfile
```
Esto simplemente indica a heroku que lo que tiene que ejecutar es un Dockerfile.

- Si intentamos hacer un push nos dará error, es necesario indicar que es un contenedor lo que hay que desplegar con "heroku stack:set container". Tras ello, hacemos "heroku push heroku master" y se nos desplegará el contenedor.

- Para automatizar el despliegue del contenedor enlazamos nuestro repositorio en github con heroku, de este modo cada vez que hagamos un push en el repositorio de github el contenedor se actualizará. (Este paso esta explicado mejor en el [anterior despliegue](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/despliegue.md)).

Tras todos los pasos anteriores el contenedor debería ser desplegado correctamente, pero en mi caso he recibido el siguiente error: "Process running mem=967M(187.5%)
Error R14 (Memory quota exceeded)", parece ser que la aplicación consume memoria más alla de los límites que permite heroku (no entiendo como puede consumir tanto).

He intentado optimizar el uso de memoria sin éxito, dado que no se evalúa la optimización de código en este hito y funciona el despliegue con azure lo dejo así (esperando que se evalúe el intento dentro de 1 punto que suponía el despliegue en más de una plataforma de la evaluación de este hito) , y intentaré arreglarlo más adelante.


Contenedor desplegado en Heroku: https://imageco-docker.herokuapp.com/



