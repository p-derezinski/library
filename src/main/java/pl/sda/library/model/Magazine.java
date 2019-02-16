package pl.sda.library.model;

public class Magazine extends Multimedium implements PaperMedium{

    private int pageCount;
    private int number;

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
