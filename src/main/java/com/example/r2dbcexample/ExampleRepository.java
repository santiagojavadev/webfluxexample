package com.example.r2dbcexample;

import com.example.r2dbcexample.entity.ExampleEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ExampleRepository extends R2dbcRepository<ExampleEntity,Integer> {
}
