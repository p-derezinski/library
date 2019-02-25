package pl.sda.library.model;

import java.util.Objects;

public class Magazine extends Multimedium implements PaperMedium{

    private int pageCount;
    private int number;

    Magazine() {

    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return pageCount == magazine.pageCount &&
                number == magazine.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pageCount, number);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "pageCount=" + pageCount +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", state=" + state +
                '}';
    }
}
