/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JRP.spring.controller;

import JRP.spring.status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class statusRestController {
    
    @RequestMapping (value="/status")
    public status estado(){
        status estado = new status("OK");
        return estado;
    }
    

}
