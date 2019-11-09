package JRP.spring;

import java.io.FileInputStream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import servicio.imageC;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringPivApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;
	
    
    // Comprueba mediante un get que /status devuelve el JSON correspondiente
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


}
