package pl.sda.library.model;

import java.util.Objects;

public class PaperBook extends Book implements PaperMedium{

    PaperBook() {

    }

    private Cover cover;
    private int pageCount;

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PaperBook paperBook = (PaperBook) o;
        return cover == paperBook.cover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cover);
    }

    // gdyby w klasie Book pola author i title były private, to zamiast np. "author" trzeba by napisać "getAuthor()"
    @Override
    public String toString() {
        return "PaperBook{" +
                "cover=" + cover +
                ", pageCount=" + pageCount +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
