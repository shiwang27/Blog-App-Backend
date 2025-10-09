package com.app.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.Payloads.JwtAuthRequest;
import com.app.blog.Payloads.JwtAuthResponse;
import com.app.blog.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Authenticates a user and returns a JWT token upon success.
     * @param request The login request containing username and password.
     * @return A ResponseEntity containing the JWT token.
     * @throws BadCredentialsException if authentication fails.
     */
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) {

        // The authentication logic is handled here.
        // If credentials are bad, it will throw a BadCredentialsException.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // If authentication is successful, the UserDetails are extracted from the Authentication object.
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Generate the JWT token.
        String token = this.jwtTokenHelper.generateToken(userDetails);

        // Create the response object.
        JwtAuthResponse response = new JwtAuthResponse();
        // Assuming you have a method named 'setToken' in your JwtAuthResponse class.
        response.setToke(token); 

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
