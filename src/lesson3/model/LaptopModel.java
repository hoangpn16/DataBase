package lesson3.model;

public class LaptopModel {
    private String maker;
    private String price;
    private String hard_drive;
    private String cpu;
    private String ram;
    private String card;
    private String sizeofdestop;
    private int quantity_sold;

    public LaptopModel(String maker, String price, String hard_drive, String cpu, String ram, String card, String sizeofdestop, int quantity_sold) {
        this.maker = maker;
        this.price = price;
        this.hard_drive = hard_drive;
        this.cpu = cpu;
        this.ram = ram;
        this.card = card;
        this.sizeofdestop = sizeofdestop;
        this.quantity_sold = quantity_sold;
    }

    public LaptopModel() {
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHard_drive() {
        return hard_drive;
    }

    public void setHard_drive(String hard_drive) {
        this.hard_drive = hard_drive;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSizeofdestop() {
        return sizeofdestop;
    }

    public void setSizeofdestop(String sizeofdestop) {
        this.sizeofdestop = sizeofdestop;
    }

    public int getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    @Override
    public String toString() {
        System.out.println("Maker: "+this.getMaker()+";"+"Price: "+this.getPrice()+";"+"Hard Drive: "+this.getHard_drive()+";"+"CPU: "+this.getCpu()+";"+"Ram: "+this.getRam()+";"+"Card: "+this.getCard()+";"+"SizeOfDestop: "+this.getSizeofdestop()+";"+"QuantitySold: "+this.getQuantity_sold());
        return null;
    }
}
