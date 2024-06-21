package com.phyex0.cassandra.repository;

import com.phyex0.cassandra.model.Library;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends CassandraRepository<Library, UUID> {
}
