package com.exam.exambackend.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambackend.Model.JWT_request;
import com.exam.exambackend.Model.JWT_response;
import com.exam.exambackend.Model.User;
import com.exam.exambackend.config.JWTutil;

@RequestMapping("/auth")
@CrossOrigin("*")
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTutil jwTutil;

    // generate token

    @PostMapping("/generateToken")
    public ResponseEntity<?> generatetoken(@RequestBody JWT_request jwt_Trequest) throws Exception {
        try {
            if (jwt_Trequest == null) {
                return ResponseEntity.ofNullable("null value");
            }
            this.authenticate(jwt_Trequest.getUsername(), jwt_Trequest.getPassword());
        } catch (Exception e) {
            throw new BadCredentialsException("not right");
        }
        String nm = jwt_Trequest.getUsername();
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(nm);
        String token = this.jwTutil.generateToken(userDetails);
        return ResponseEntity.ok(new JWT_response(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("User Disabled");
        }
    }

    @GetMapping("/currentuser")
    public User getcurrentuser(Principal principal) {
        return (User) (this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}