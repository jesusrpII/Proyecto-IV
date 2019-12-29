package JRP.spring.controller;

import JRP.spring.storage.StorageService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import servicio.imageC;



@Controller
public class imageController {

    private final StorageService storageService;

    @Autowired
    public imageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        return "formSubirImagen.html";
    }

    @PostMapping("/comprimido")
    @ResponseBody
    public ResponseEntity<Resource> handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("factor") float factor,
            RedirectAttributes redirectAttributes) throws Exception {

        if ("image/png".equals(file.getContentType())){
            throw new Exception("PNG compression not implemented");
        }
        else {
            //storageService.store(file);        // No nos interesa guardar ninguna imagen
            imageC o = new imageC();
            try {
                o.setImagenIni(file);
            } catch (Exception ex) {
                Logger.getLogger(imageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            o.compresionSimple(factor);       
            Resource comprimida = storageService.loadAsResource(o.getImagenCom().getName());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + comprimida.getFilename() + "\"").body(comprimida);
        }
    }

    /* Descomentar si se quiere acceder a algun archivo en concreto (como solo existe una unica imagen)
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    */

}
