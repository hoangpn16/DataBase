package laptop.model;

public class Counter {
    private String quantity;
    private String makers;

    public Counter() {
    }

    public Counter(String makers, String quantity) {
        this.quantity = quantity;
        this.makers = makers;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMakers() {
        return makers;
    }

    public void setMakers(String maker) {
        this.makers = maker;
    }
}
