package be.ugent.objprog.books;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    private final Map<String, Book> catalog;

    public Main() {
        catalog = new HashMap<>();
        initCatalog();
    }

    private void initCatalog() {
        // TODO vul catalog op met alle boeken uit het bestand books.xml in be/ugent/objprogs/books
        //      sleutels zijn de book ids, waarden zijn records van het type Book


        try {
            InputStream is = Objects.requireNonNull(
                    ClassLoader.getSystemClassLoader().getResourceAsStream("be/ugent/objprog/books/books.xml")
            );
            Document document = new SAXBuilder().build(is);
            Element books = document.getRootElement();

            catalog.putAll(books.getChildren("book").stream()
                .collect(Collectors.toMap(
                    element -> element.getAttributeValue("id"),
                    element -> new Book(
                            element.getAttributeValue("id"),
                            element.getChildTextTrim("author"),
                            element.getChildTextTrim("title"),
                            element.getChildTextTrim("genre"),
                            element.getChildTextTrim("description")
                    )
                    )));

        } catch (JDOMException | IOException e) {
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
