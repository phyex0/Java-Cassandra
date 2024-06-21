package com.phyex0.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.time.LocalDate;
import java.util.UUID;

@UserDefinedType
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @PrimaryKeyColumn
    private UUID id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private LocalDate publishDate;

    @Column
    private String ISBN;

    @Column
    private String description;
}
