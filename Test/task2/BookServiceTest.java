package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;


class BookServiceTest {

    BookRepository bookRepository;
    BookService bookService;

    @BeforeEach
    void BeforeEach() {
        bookRepository =  mock(BookRepository.class);
        bookService = new BookService(bookRepository);

    }

    @Test
    void findBookByIdTest() {
        when(bookRepository.findById("321")).thenReturn(new Book("321"));
        Book book = bookService.findBookById("321");
        assertEquals("321", book.getId());
        verify(bookRepository, times(1)).findById("321");

    }

    @Test
    void findAllBooksTest() {
        List<Book> books = bookService.findAllBooks();
        when(bookRepository.findAll()).thenReturn(books);
        assertEquals(books, bookService.findAllBooks());
        verify(bookRepository, times(2)).findAll();
    }
}