package com.phyex0.cassandra.service;

import com.phyex0.cassandra.exception.LibraryAlreadyExistsException;
import com.phyex0.cassandra.exception.LibraryNotFoundException;
import com.phyex0.cassandra.model.Book;
import com.phyex0.cassandra.model.Library;
import com.phyex0.cassandra.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;


    @Override
    @Transactional
    public Library createLibrary(Library library) {
        if (Objects.nonNull(library.getId())) {
            Optional<Library> byId = libraryRepository.findById(library.getId());
            if (byId.isPresent()) {
                throw new LibraryAlreadyExistsException(String.format("This library [%s] already exists.", library.getId()));
            }
        }

        library = libraryRepository.save(library);
        return library;
    }

    @Override
    public Library getLibrary(UUID id) {
        Optional<Library> byId = libraryRepository.findById(id);

        return byId.orElseThrow(() -> new LibraryNotFoundException(String.format("Library [%s] not found", id)));
    }

    @Override
    @Transactional
    public Library updateLibrary(Library library) {
        if (Objects.nonNull(library.getId())) {
            return libraryRepository.save(library);
        }

        throw new LibraryNotFoundException(String.format("Id must not be empty"));
    }

    @Override
    @Transactional
    public void deleteLibrary(UUID id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooksByLibrary(UUID id) {
        Optional<Library> byId = libraryRepository.findById(id);
        Library library = byId.orElseThrow(() ->
                new LibraryNotFoundException(String.format("Library [%s] not found.", id)));
        return library.getBooks();
    }

    @Override
    public List<Book> getAllBooksByLibraryByDate(UUID id, LocalDate publishDate) {
        return getAllBooksByLibrary(id)
                .stream()
                .filter(book -> book.getPublishDate().isBefore(publishDate))
                .toList();
    }

    @Override
    public Slice<Library> getAll(Pageable pageable) {
        Slice<Library> all = libraryRepository.findAll(pageable);
        return new SliceImpl<>(all.getContent(), pageable, all.hasNext());
    }
}
