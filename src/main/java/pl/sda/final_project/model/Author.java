package pl.sda.final_project.model;

import pl.sda.final_project.ProductDto;

import javax.persistence.Embeddable;

@Embeddable
public class Author {

    private String authorFirstName;
    private String authorLastName;

    public static Author apply(ProductDto productDto) {
        Author author = new Author();
        author.authorFirstName = productDto.getAuthorFirstName();
        author.authorLastName = productDto.getAuthorLastName();
        return author;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }
}
