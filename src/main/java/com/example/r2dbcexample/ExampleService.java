package com.example.r2dbcexample;

import com.example.r2dbcexample.entity.ExampleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;
    public Mono<ExampleRecord> getExample(Integer id) {
        return exampleRepository.findById(id).map(this::toDto);
    }

    private ExampleRecord toDto(ExampleEntity entity) {
        return new ExampleRecord(entity.getId(),entity.getName(),entity.getKilowatt());
    }

    private ExampleEntity toEntity(ExampleRecord record){
        return ExampleEntity.builder().name(record.name())
                .id(record.id()).kilowatt(record.killowatt())
                .build();
    }

    public Flux<ExampleRecord> getAllExample() {
        return exampleRepository.findAll()
                    .map(this::toDto);
    }

    public Mono<Void> delete(Integer id){
        //exampleRepository.findById(id).
        return exampleRepository.deleteById(id);
    }

    public Mono<ExampleRecord> create(ExampleRecord exampleRecord) {
        return exampleRepository.save(toEntity(exampleRecord)).map(this::toDto);
    }

    public Mono<ExampleRecord> update(Integer id, ExampleRecord exampleRecord) {
        //exampleRepository.findById(id).
        return exampleRepository.save(toEntity(exampleRecord)).map(this::toDto);
    }
}
