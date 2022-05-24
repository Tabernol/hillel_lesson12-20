package hw17.model;

import lombok.Data;

import java.util.*;

@Data
public class Library {
    private Map<String, Book> catalog = new HashMap<>();

}
