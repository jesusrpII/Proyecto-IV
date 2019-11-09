### Test

Para la implementación y ejecución de los test se ha utilizado una biblioteca de Spring Boot, llamada Spring Boot Starter Test que utiliza [junit4](https://junit.org/junit4/).

Se han añadido los test que se utilizaron en el hito anterior, que comprueban simplemente que las funciones basicas funcionan correctamente:

```yaml

@Test
    public void testGeneral() {
        System.out.println("cargarImagenUrl carga imagen de prueba");
        String url = "https://image.freepik.com/foto-gratis/camino-rural-tematico-otono-concepto-cordillera_53876-23187.jpg";
        imageC o = new imageC();
        o.cargarImagenURL(url);
        assertFalse(o.getImagenIni()==null);         // Se carga la imagen
        assertEquals(o.getExtension(),"jpg");        // Se lee bien la extension
    }
    
    // Test que comprueba que una imagen cargada se comprime correctamente
    
    @Test
    public void compresionSimple(){
        System.out.println("Cargar imagen de prueba");
        String url = "https://image.freepik.com/foto-gratis/camino-rural-tematico-otono-concepto-cordillera_53876-23187.jpg";
        imageC o = new imageC();
        o.cargarImagenURL(url);
        System.out.println("Comprimiendo imagen de tamaño "+o.getImagenIni().length());
        o.compresionSimple(0.5f);                             // Se establece un factor de compresión de 50%

        assertEquals(o.getImagenIni().length(),176503);       // Se comprueba que se ha cargado bien la imagen comprobando que el tamaño es correcto
        assertTrue(o.getImagenCom().length()< o.getImagenIni().length()); // Si la compresión se ejecuta bien, el tamaño de la imagen resultante debe ser menor
    }

```

Y para comprobar el funcionamiento correcto de la API, he utilizado la biblioteca mockmvc que permite simular el comportamiento de un cliente, creando peticiones http con los métodos que se le indiquen (get,post..)

En la primera función simplemente comprueba que se levanta el proyecto correctamente (/status devuelve el JSON correspondiente) y la segunda función comprueba que se pueden subir imagenes en la aplicacion (para ello realiza una petición POST con una imagen creada como ejemplo)

```yaml
/ Comprueba mediante un get que /status devuelve el JSON correspondiente
    @Test
    public void testStatus() throws Exception {
        System.out.println("comprobar estado");
        this.mockMvc.perform(get("/status")).andDo(print()).andExpect(status().isOk()).andExpect(content().json("{'status':'OK'}"));
    }
    
    // Comprueba que se pueden subir imagenes correctamente mediante un post
    @Test
    public void subidaArchivos() throws Exception {
        
        imageC o = new imageC();
        o.cargarImagenURL("https://image.freepik.com/foto-gratis/camino-rural-tematico-otono-concepto-cordillera_53876-23187.jpg");
        FileInputStream fis = new FileInputStream(o.getImagenIni());
        MockMultipartFile multipartFile = new MockMultipartFile("file", "imagen.jpg",
                "image/jpeg", fis);
        this.mockMvc.perform(MockMvcRequestBuilders.fileUpload("/comprimido").file(multipartFile))
                .andExpect(status().isOk());
    }
        
```


Todas estas funciones anteriores se encuentran implementadas en [test](https://github.com/jesusrpII/Proyecto-IV/blob/master/imageCo/src/test/java/JRP/spring/SpringPivApplicationTests.java), en el cual se pueden observar con más detalle.

