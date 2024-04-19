package com.example.crud2.decorater;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestSession {

    private JwtUserDecorator jwtUserDecorator;
}
