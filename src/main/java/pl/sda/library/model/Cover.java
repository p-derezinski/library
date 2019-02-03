package pl.sda.library.model;

public enum Cover {

    SOFT("miękka"), HARD("twarda");

    private String polishCoverName;

    Cover(String polishCoverName) {
        this.polishCoverName = polishCoverName;
    }

    public String getPolishCoverName() {
        return polishCoverName;
    }
}
