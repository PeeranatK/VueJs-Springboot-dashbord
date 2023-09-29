package com.example.backend.filter;

import java.io.IOException;
//import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.backend.services.JwtService;
import com.example.backend.services.UserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailService userDetailsService;

    // @Override
    // protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    //     Enumeration<String> headerNames = request.getHeaderNames();
    //     while (headerNames.hasMoreElements()) {
    //         String headerName = headerNames.nextElement();
    //         System.out.println(headerName + " : " + request.getHeader(headerName));
    //     }
        
    //     String authHeader = request.getHeader("Authorization");
    //     String token = null;
    //     String username = null;
    //     System.out.println("request : " + request.getContentLength());
    //     System.out.println("response : " + response);
    //     System.out.println("filterChain : " + filterChain);
    //     System.out.println("authHeader : " + authHeader);
    //     if (authHeader != null && authHeader.startsWith("Bearer ")) {
    //         token = authHeader.substring(7);
    //         username = jwtService.extractUsername(token);
    //         System.out.println("token : " + token);
    //         System.out.println("user : " + username);
    //     }

    //     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    //         UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    //         if (jwtService.validateToken(token, userDetails)) {
    //             UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    //             authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    //             SecurityContextHolder.getContext().setAuthentication(authToken);
    //         }
    //     }
    //     filterChain.doFilter(request, response);
    // }
    @Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type");
    } else {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        System.out.println("request : " + request.getContentLength());
        System.out.println("response : " + response);
        System.out.println("filterChain : " + filterChain);
        System.out.println("authHeader : " + authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
            System.out.println("token : " + token);
            System.out.println("user : " + username);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}

}
