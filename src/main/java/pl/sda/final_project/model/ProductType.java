package pl.sda.final_project.model;

public enum ProductType {

    FOOD("jadalne"),
    NOT_FOOD("niejadalne");

    private final String plName;

    private ProductType(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
