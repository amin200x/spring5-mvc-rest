package guru.springframework.controller;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.domain.Category;
import guru.springframework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/api/v1/categories")

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    // public ResponseEntity<CategoryListDTO> getCategories() {
    public CategoryListDTO getCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
        //return new ResponseEntity<>(new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    //public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
        //return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
