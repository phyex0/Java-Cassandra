package com.phyex0.cassandra.service;

import com.phyex0.cassandra.model.Book;
import com.phyex0.cassandra.model.Library;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LibraryService {

    Library createLibrary(Library library);

    Library updateLibrary(Library library);

    void deleteLibrary(UUID id);

    Library getLibrary(UUID id);

    List<Book> getAllBooksByLibrary(UUID id);

    List<Book> getAllBooksByLibraryByDate(UUID id, LocalDate publishDate);

    Slice<Library> getAll(Pageable pageable);
}
