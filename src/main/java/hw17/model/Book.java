package hw17.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Book extends Library {
    String author;
    String nameOfBook;
    String text;
}
