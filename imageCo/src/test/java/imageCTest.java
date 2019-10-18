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
        System.out.println("cargarImagenUrl");
        String url = "https://image.freepik.com/foto-gratis/camino-rural-tematico-otono-concepto-cordillera_53876-23187.jpg";
        imageC o = new imageC();
        o.cargarImagenUrl(url);
        assertFalse(o.getImagen()==null);
        assertEquals(o.getExtension(),"image/jpeg");     
    }

}
