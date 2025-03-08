package be.ugent.objprog.books;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private final Map<String, Book> catalog;

    public Main() {
        catalog = new HashMap<>();
        initCatalog();
    }

    private void initCatalog() {
        // TODO


        try (InputStream is = Main.class.getResourceAsStream("books.json")) {
            if (is == null) throw new FileNotFoundException("books.json not found");

            ObjectMapper mapper = new ObjectMapper();
            List<Book> list = mapper.readerForListOf(Book.class).readValue(is);

            catalog.putAll(list.stream().collect(Collectors.toMap(Book::id, book -> book)));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void run() {
        // printing all fantasy books
        for (Book book : catalog.values()) {
            if (book.genre().equals("Fantasy")) {
                System.out.println(book.title().toUpperCase());
                System.out.println(book.description());
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
