package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JSONMain {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper =
                new ObjectMapper().registerModule(new JavaTimeModule());

        //反序列畫
        Book book = mapper
                .readValue(new FileInputStream("book.json"), Book.class);
        System.out.println(book.id);
        System.out.println(book.author);
        System.out.println(book.isbn);
        System.out.println(book.name);
        System.out.println(book.price);
        System.out.println(book.pubDate);

        //序列化
        String json = mapper.writeValueAsString(book);
        System.out.println(json);
    }
}
