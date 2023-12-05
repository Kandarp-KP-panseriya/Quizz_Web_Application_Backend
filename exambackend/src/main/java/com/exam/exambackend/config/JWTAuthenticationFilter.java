package com.exam.exambackend.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter
{


    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTutil jwtutil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException 
            
    {
        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println("This is Token and token  Fatching by  Header:"+requestTokenHeader);

        String username = null;
        String token = null;

        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
        {
            token = requestTokenHeader.substring(7);
            try
            {
            
                //yes
                username = this.jwtutil.extractUsername(token);
                System.out.println("username fatch by token-------->>>>>>>>>>>"+username);
                
            }catch(Exception e)
            {
                System.out.println("exception in fileter class"+e);
            }

        }
        else
        {
            System.out.println("Invalid Token, Bearer not started");
        }



        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null )
        {

            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validtoken = this.jwtutil.validateToken(token, userDetails);
            if(validtoken)
            {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                
                
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            
        }
        else
        {
            System.out.println("Validation falid");
        }


        filterChain.doFilter(request, response);
    }
     
}