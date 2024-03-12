package com.example.r2dbcexample.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("example")
public class ExampleEntity {
    @Id
    private Integer id;

    private String name;

    private Integer kilowatt;

}
