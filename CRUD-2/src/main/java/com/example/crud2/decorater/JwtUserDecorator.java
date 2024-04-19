package com.example.crud2.decorater;

import com.example.crud2.enums.Roles;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor@NoArgsConstructor
public class JwtUserDecorator {

    private String id;
    private Set<Roles> userRoles;

}
