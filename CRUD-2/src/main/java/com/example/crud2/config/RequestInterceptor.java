package com.example.crud2.config;

import com.example.crud2.AllMessages.ResponseConstant;
import com.example.crud2.decorater.DataResponse;
import com.example.crud2.decorater.RequestSession;
import com.example.crud2.decorater.Response;
import com.example.crud2.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestInterceptor implements HandlerInterceptor
{
    private final RequestSession requestSession;

    public RequestInterceptor(RequestSession requestSession) {
        this.requestSession = requestSession;
    }


    private void setResponse(HttpServletResponse response, String ms) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatus(new Response(HttpStatus.BAD_REQUEST, "ERROR", ms));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(dataResponse));

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String token = request.getHeader("TOKEN");
        System.out.println(request.getRequestURI());
        //UserServiceImpl.sendToken(token);
        if (token == null)
        {
            setResponse(response, ResponseConstant.AUTHENTICATION_IS_NOT_PRESENT_IN_REQUEST);
            return false;
        }
        try
        {
              JWTUtils.decodeJwtToken(token);
        }
        catch (SignatureException | MalformedJwtException e)
        {
            setResponse(response, ResponseConstant.TOKEN_IS_INVALID);
            return false;
        } catch (ExpiredJwtException e)
        {
            setResponse(response, ResponseConstant.TOKEN_IS_EXPIRED);
            return false;
        }
        requestSession.setJwtUserDecorator(JWTUtils.getTokenData(token));
        return true;
    }

    // Response is intercepted by this method before reaching the client
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //* Business logic just before the response reaches the client and the request is served
        try {
            System.out.println("2 - postHandle() : After the Controller serves the request (before returning back response to the client)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method is called after request & response HTTP communication is done.
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //* Business logic after request and response is Completed
        try {
            System.out.println("3 - afterCompletion() : After the request and Response is completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

