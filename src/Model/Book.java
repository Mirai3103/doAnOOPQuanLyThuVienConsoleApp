package Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 321543421131L;
    private int id;
    private String name;
    private int totalPages;
    private String language;
    private String author;
    private String publisher;
    private short publishYear;
    private String description;
//    private final List<Category>categories = new ArrayList<>();

}
