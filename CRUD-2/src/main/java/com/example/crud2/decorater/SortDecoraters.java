package com.example.crud2.decorater;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class SortDecoraters {

    private String sortBy;
    private String orderBy;
    //private Sort.Direction orderBy;
}
