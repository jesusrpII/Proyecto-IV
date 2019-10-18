
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;


/**
 *
 * @author jesus
 */
public class imageC {
    
    private BufferedImage imagen;
    private String ext;

    
    public imageC(){
        imagen=null;
        ext = "";
    }
    
    public void cargarImagenUrl(String url){
        try{      
            URL dir = new URL(url);
            imagen = ImageIO.read(dir);
            ext = URLConnection.guessContentTypeFromName(dir.getFile());
            
        }catch(IOException ex) {
            ex.printStackTrace();
        }      
        
    }
    
    
    public BufferedImage getImagen(){
        return imagen;
    }
    
    public String getExtension(){
        return ext;
    }
    
}
