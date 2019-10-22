import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jesus
 */
public class imageCTest {
    
    public imageCTest() {
    }

    // Test que comprueba que una imagen y su extension se lee correctamente
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
