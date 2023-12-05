package com.exam.exambackend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.Categories;

@Service
public interface CategoriesServices 
{

    public Categories addCategories(Categories categories);
    public Categories updatecatagories(Categories categories);
    public List<Categories> getcatagories();
    public Categories getsingleCategories(Long id);
    public void deletecategories(Long id);
    
}