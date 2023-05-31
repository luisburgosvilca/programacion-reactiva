package com.example.tutorialwebflux.controller;

import com.example.tutorialwebflux.entity.Product;
import com.example.tutorialwebflux.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    @ResponseBody
    public Flux<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Mono<Product> getById(@PathVariable("id") int id){
        return productService.getById(id);
    }

    @PostMapping
    @ResponseBody
    public Mono<Product> save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Mono<Product> update(@PathVariable("id") int id, @RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public Mono<Void> deleteById(@PathVariable("id") int id) {
        return productService.deleteById(id);
    }

}
