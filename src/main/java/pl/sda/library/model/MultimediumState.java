package pl.sda.library.model;

public interface MultimediumState {

    MultimediumState borrowMedium(String firstName, String lastName);
    MultimediumState returnMedium();

}
