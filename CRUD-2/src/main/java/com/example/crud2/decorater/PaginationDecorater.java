package com.example.crud2.decorater;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class PaginationDecorater
{
    private Integer pageNumber;
    private Integer pageSize;
}
