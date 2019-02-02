package pl.sda.library.model;

public final class BookBilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;

    public BookBilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookBilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookBilder title(String title) {
        this.title = title;
        return this;
    }

    public Book build() {
        //TODO
        Book book = new Book();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        return book;
    }

}
