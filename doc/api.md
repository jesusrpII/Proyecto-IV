### API

La API desarrollada utiliza como base las funciones de la clase [imageC.java](https://github.com/jesusrpII/Proyecto-IV/blob/master/imageCo/src/main/java/servicio/imageC.java), como ya se ha indicado se inicia con mvn spring-boot:start y se puede acceder a partir de **localhost:8080**.

**HTTP Request de la API:**

|METHOD|URI|RESPONSE|
|------------------|---------|----------|
| GET | /  | Formulario html  (para subir una imagen)|
| GET | /status |  JSON {"status":"OK"} |
| POST | /comprimido | Devuelve multipart file (la imagen que se pasa en el header del request pero después de ser comprimida) |

En resumen, utilizando "/" accedemos a un formulario html que nos permite subir una imagen, el formulario ejecuta "/comprido" mediante POST (con la imagen en el header del post request), esta imagen (que es de tipo multipart file) es procesada y comprimida, como respuesta obtenemos dicha imagen comprimida lista para descargar.


Para información sobre la implementación de estas rutas: [controladores](https://github.com/jesusrpII/Proyecto-IV/tree/master/imageCo/src/main/java/JRP/spring/controller)

### Configuración

Para subir y descargar archivos en spring boot es necesario crear unas clases de configuración, otro factor a tener en cuenta es que spring boot trabajo con MultipartFile y vamos a tener que convertirlo a File para trabajar con las imagenes (esto se ha solucionado en [imageC.java](https://github.com/jesusrpII/Proyecto-IV/blob/master/imageCo/src/main/java/servicio/imageC.java)).

[Ver las clases de configuración](https://github.com/jesusrpII/Proyecto-IV/tree/master/imageCo/src/main/java/JRP/spring/storage)

Para más información la siguiente página puede resultar muy útil: [Spring.io](https://spring.io/guides/gs/uploading-files/)


