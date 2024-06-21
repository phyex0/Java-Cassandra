package com.phyex0.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {

    @Id
    @Generated
    @PrimaryKeyColumn
    private UUID id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String manager;

    @Column
    private List<String> workers = new ArrayList<>();

    @Column
    private List<Book> books = new ArrayList<>();


}
