package com.phyex0.cassandra.controller;

import com.phyex0.cassandra.model.Book;
import com.phyex0.cassandra.model.Library;
import com.phyex0.cassandra.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        return ResponseEntity.ok(libraryService.createLibrary(library));
    }

    @PutMapping
    public ResponseEntity<Library> updateLibrary(@RequestBody Library library) {
        return ResponseEntity.ok(libraryService.updateLibrary(library));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLibrary(@RequestParam UUID id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Library> getLibrary(@RequestParam UUID id) {
        return ResponseEntity.ok(libraryService.getLibrary(id));
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(@RequestParam UUID id) {
        return ResponseEntity.ok(libraryService.getAllBooksByLibrary(id));
    }

    @GetMapping("/books-by-date")
    public ResponseEntity<List<Book>> getBooksByDate(@RequestParam UUID id, @RequestParam LocalDate localDate) {
        return ResponseEntity.ok(libraryService.getAllBooksByLibraryByDate(id, localDate));
    }

    @GetMapping("/all")
    public ResponseEntity<Slice<Library>> getAll(Pageable pageable) {
        return ResponseEntity.ok(libraryService.getAll(pageable));
    }
}
