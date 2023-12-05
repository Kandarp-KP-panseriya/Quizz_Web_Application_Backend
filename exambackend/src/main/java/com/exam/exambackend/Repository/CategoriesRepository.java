package com.exam.exambackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.exambackend.Model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories,Long>  {

}
