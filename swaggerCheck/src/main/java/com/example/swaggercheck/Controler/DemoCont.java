package com.example.swaggercheck.Controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCont
{
    @GetMapping
    public String letsCheckMethod()
    {
        return "okkkkkk";
    }

}
