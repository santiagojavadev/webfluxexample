package com.example.r2dbcexample;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/example")
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/{id}")
    public Mono<ExampleRecord> getExample(@PathVariable("id") Integer id){
        return exampleService.getExample(id);
    }

    @GetMapping
    public Flux<ExampleRecord> getAllExample(){
        return exampleService.getAllExample();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        return exampleService.delete(id);
    }

    @PostMapping
    public Mono<ExampleRecord> create(@RequestBody ExampleRecord exampleRecord){
        return exampleService.create(exampleRecord);
    }

    @PutMapping("/{id}")
    public Mono<ExampleRecord> update(@PathVariable("id") Integer id, @RequestBody ExampleRecord exampleRecord){
        return exampleService.update(id,exampleRecord);
    }
}
