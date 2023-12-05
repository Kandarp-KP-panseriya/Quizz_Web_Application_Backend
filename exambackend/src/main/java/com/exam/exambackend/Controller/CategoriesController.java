package com.exam.exambackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exambackend.Model.Categories;
import com.exam.exambackend.Services.CategoriesServices;

@RestController
@RequestMapping("/categorie")
@CrossOrigin("*")
public class CategoriesController {

    @Autowired
    private CategoriesServices categoriesServices;

    @PostMapping("/")
    public ResponseEntity<Categories> addCategories(@RequestBody Categories categories)
    {
        Categories c = this.categoriesServices.addCategories(categories);
        return ResponseEntity.ok(c);
    } 

    @GetMapping("/{categoriesid}")
    public Categories getsingleCategories(@PathVariable("categoriesid") Long cateid)
    {
        return this.categoriesServices.getsingleCategories(cateid);
    }

    @GetMapping("/")
    public List<Categories> getcatagories()
    {
        return this.categoriesServices.getcatagories();
    }

    @PutMapping("/")
    public ResponseEntity<?> updatecategories(@RequestBody Categories categories)
    {
        this.categoriesServices.updatecatagories(categories);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<?> DeleteMapping(@PathVariable("cid") Long cid)
    {
        this.categoriesServices.deletecategories(cid);
        return ResponseEntity.ok("Deleted");
    }
    
}
