## Despliegue en Heroku

Para esta fase del proyecto, se a elegido como PaaS [Heroku](https://www.heroku.com/) debido a que es totalmente gratis y sencillo de utilizar.

Los pasos necesarios para desplegar el proyecto en Heroku son:

- Crear cuenta en Heroku (registrarse desde su página es muy sencillo)

- Instalar el CLI de Heroku en nuestro sistema, yo he utilizado el gestor de paquetes snap: "sudo snap install heroku --classic"

- Una vez instalado, nos logueamos, de esta forma vinculamos nuestra cuenta con la sesión: "heroku login" (Nos aparecera una ventana en el buscador para que introduzcamos nuestras credenciales).

- Estando en el directorio raíz de nuestro proyecto, creamos nuestra aplicación heroku mediante: "heroku create imageco" (imageco será el nombre de nuestra app).
Esto lo que hace es crear la aplicación y crear un repositorio remoto heroku en nuestro repositorio local.

- Ya solo queda desplegar nuestro proyecto (notese que no se ha tenido que indicar ningún buildpack para el lenguaje de nuestro proyecto ya que heroku lo detecta automáticamente, si no deberíamos indicarlo mediante: "heroku buildpacks:set heroku/java").
   
    A la hora de desplegar el proyecto bastaría con "git push heroku master", pero hay que tener en cuenta (o por lo menos en mi        caso) que el directorio del proyecto no se encuentra en la raíz por lo que no encontrará nada que "construir" y dará error.

    Para hacer push del directorio donde se encuentra el código que queremos desplegar debemos añadir lo siguiente: "git subtree push --prefix imageCo heroku master"

    Una vez hecho esto, el proyecto se despliega correctamente (heroku detecta el pom.xml y detecta que se trata de un proyecto escrito en java). [enlace](https://git.heroku.com/imageco.git)

- Adicionalmente, se puede hacer que heroku detecte automáticamente los cambios en nuestro repositorio de GitHub (de lo contrario deberiamos hacer un push a heroku para que detectase los cambios). Esto lo podemos realizar desde la web:
    - Enlazamos nuestro repositorio en gitHub con heroku.

    ![Imagen1](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/heroku1.png)

    - Activamos la opción Automatic Deploys (Además heroku nos permite habilitar otra opción interesante para que se actualice heroku únicamente cuando el push en gitHub pasa los tests de integración continua)

    ![Imagen2](https://github.com/jesusrpII/Proyecto-IV/blob/master/doc/images/heroku2.png)

  
- Ya nuestra aplicación se encuentra desplegada, ya solo queda aclarar que heroku necesita un archivo llamado "Procfile" para conocer que comandos ejecutar para lanzar nuestra app, en caso de no encontrarse ningún "Procfile" en el directorio raíz de nuestro proyecto, se ejecutará un Procfile por defecto.
En mi caso no he especificado ningún Procfile pues se ejecuta por defecto:

```yaml
 web java -Dserver.port=$PORT $JAVA_OPTS -jar target/imageCo-0.0.1-SNAPSHOT.jar 
```

Con "web" indicamos que se ejecuta un proyecto web, escrito en java con el puerto especificado en $PORT, se ejecuta "target/imageCo-0.0.1-SNAPSHOT.jar" que es el jar que genera maven para mi proyecto. Por ahora me vale este "Procfile" por defecto por lo que no he añadido ninguno.



#### Bibliografía
[Heroku, cómo desplegar un proyecto Spring-Boot](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)
[Heroku, Procfile](https://devcenter.heroku.com/articles/procfile)
[Cómo desplegar un proyecto que no se encuentra en el directorio raíz](https://coderwall.com/p/ssxp5q/heroku-deployment-without-the-app-being-at-the-repo-root-in-a-subfolder)
 
