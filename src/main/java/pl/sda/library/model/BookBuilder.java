package pl.sda.library.model;

// klasa typu generycznego
public abstract class BookBuilder<BookClass extends Book> {

    protected String authorFirstName;
    protected String authorLastName;
    protected String title;

    public BookBuilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookBuilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    //public abstract BookBuilderClass getBookBuilderClass();

    public abstract BookClass build();

}
