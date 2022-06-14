package hw20.model;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Book extends Library {
    String author;
    String nameOfBook;
}
