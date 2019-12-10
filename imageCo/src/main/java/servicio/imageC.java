package servicio;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author jesus
 */
public class imageC {
    ;
    private File imagenIni;
    private File imagenCom;
    private String path = "./src/main/resources/static/";

    
    public imageC(){
        imagenIni = new File(path+"imagen.jpg");
    }
    
    
    // Funcion que descarga una imagen desde un url y la guarda en un File
    
    public void cargarImagenURL(String url){
         try{      
            URLConnection con = new URL(url).openConnection();
            
            con.getContentType();
            InputStream in = con.getInputStream();
            OutputStream out = new FileOutputStream(imagenIni);
            
            int b = 0;
            while (b != -1) {
                b = in.read();
                if (b != -1)
                  out.write(b);
            }
            in.close();
            out.close();
            
        }catch(IOException ex) {
            ex.printStackTrace();
        }  
    }

    
    public void setImagenIni(MultipartFile imagen ) throws Exception{      
        try {
            String file_path= path+"imagen.jpg";         // Por defecto la imagen es jpg
           
            switch(imagen.getContentType()){
                case "image/png":  throw new Exception("PNG compression not implemented");//file_path= path+"imagen.png";
            }
            
            imagenIni = new File(file_path);
            System.out.print(imagen.getContentType());
            imagenIni.createNewFile();
            FileOutputStream fos = new FileOutputStream(imagenIni);
            fos.write(imagen.getBytes());
            fos.close();
           
            
            } catch (IOException ioe){
            }
        
    }
    
  
    // Compresión simple utilizando la clase ImageWriter de java
    
    public void compresionSimple(float factor){
        try {
            BufferedImage img = ImageIO.read(imagenIni);
            
            
            imagenCom = new File("./src/main/resources/static/compressed_image.jpg");
            OutputStream out = new FileOutputStream(imagenCom);                    // Se crear un stream de salida

            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(this.getExtension());  // Para la compresion es necesario conocer la extension (jpg,png..)
            ImageWriter writer = (ImageWriter) writers.next();

            ImageOutputStream iout = ImageIO.createImageOutputStream(out);          // Se crear un imageoutputstream con el stream con nuestro File de salida
            writer.setOutput(iout);

            ImageWriteParam param = writer.getDefaultWriteParam();

            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(factor);                         // Aqui se establece el factor de compresión
            writer.write(null, new IIOImage(img, null, null), param);    // Se realiza la compresion

            out.close();
            iout.close();
            writer.dispose();
        } catch (IOException ex) {
            Logger.getLogger(imageC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Devuelve extension utilizando la clase FilenameUtils de java
    public String getExtension(){
        return FilenameUtils.getExtension(imagenIni.getName());
    }
    
    public File getImagenIni(){
        return imagenIni;
    }
    
    public File getImagenCom(){
        return imagenCom;
    }
    
}
