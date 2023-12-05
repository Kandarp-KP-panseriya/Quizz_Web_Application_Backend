package com.exam.exambackend.Services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exambackend.Model.Categories;
import com.exam.exambackend.Repository.CategoriesRepository;
import com.exam.exambackend.Services.CategoriesServices;

@Service
public class Categoriesimple implements CategoriesServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Categories addCategories(Categories categories) {

        Categories c1 = this.categoriesRepository.save(categories);
        return c1;

    }

    @Override
    public Categories updatecatagories(Categories categories) {
        
        Categories c1 = this.categoriesRepository.save(categories);
        return c1;

    }

    @Override
    public List<Categories> getcatagories() {

        List<Categories> list = this.categoriesRepository.findAll();
        return list;
    }

    @Override
    public Categories getsingleCategories(Long id) {

        Categories C1 = this.categoriesRepository.findById(id).get();
        return C1;

    }

    @Override
    public void deletecategories(Long id) {

        this.categoriesRepository.deleteById(id);
    }

}
