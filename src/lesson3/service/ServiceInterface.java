package lesson3.service;

import lesson3.model.LaptopModel;

import java.util.List;

public interface ServiceInterface {
    List<LaptopModel> findbyMaker(String maker);

    List<LaptopModel> findbyPrice(String a, String b);

    List<LaptopModel> findbyMakerAndHardDrive(String maker, String hard_drive);

    List<LaptopModel> findBestSeller();

    List<LaptopModel> findbyCPU(String cpu);

    List<LaptopModel> findbyRam(String ram);
    List<LaptopModel> printAllListLaptop();
}
