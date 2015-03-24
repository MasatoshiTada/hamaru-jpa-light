package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerIdSearchSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        System.out.println(manager.getClass().getName());
        Manufacturer manufacturer = manager.find(Manufacturer.class, 19985678);
        System.out.println(manufacturer.getName());
        
        System.out.println(manager.contains(manufacturer));
        Manufacturer manufacturer2 = manager.find(Manufacturer.class, 19985678);
        System.out.println(manufacturer.getName());
        
        manager.close();
        factory.close();
    }
}
