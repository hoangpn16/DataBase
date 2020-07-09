package lesson3.service;

import lesson3.model.LaptopModel;

import java.util.List;

public interface ServiceInterface {
    List<LaptopModel> findBestSold();

    List<LaptopModel> searchLaptop(String maker, String from_price, String to_price, String hard_drive, String cpu, String ram, String card, String sizeofdestop, String quantity_sold, String order);
}
