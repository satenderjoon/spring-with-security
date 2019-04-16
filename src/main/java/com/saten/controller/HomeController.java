/**
 * 
 */
package com.saten.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author satender
 *
 */
@RestController
public class HomeController {

    @RequestMapping("/home")
    String home() {
        return "home";
    }
}
