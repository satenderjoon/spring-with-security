/**
 * 
 */
package com.saten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saten.service.UserService;

/**
 * @author satender
 *
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    
    /*@PostMapping(value = "/login")
    public String login(@RequestBody LoginDTO loginDTO) throws Exception {

        // User userDetails = (User)
        // userDetailsService.loadUserByUsername(loginDTO.getEmail());

        User user = userService.findByUsername(loginDTO.getEmail());

        if (user != null) {
            System.out.println("Hello logged In");
            Long sessionTime = 18000000l;
        }
        return "Login";
    }*/
    
    @GetMapping(value = "/login")
    public String loginPage() throws Exception {
        return "Login";
    }
}
