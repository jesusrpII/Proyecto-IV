/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JRP.spring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jesus
 */

@Controller
public class errorController implements ErrorController{
 
    @RequestMapping("/error")
    public String handleError() {
        return "pag_error";
    }
    
    @Override
    public String getErrorPath() {
        return "/pag_error"; 
    }
    
}
