package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerUnDeleteSample1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        manufacturer.setName("FUGA");
        manager.remove(manufacturer);
        
        manager.flush();
        tx.commit();
        
        manager.close();
        factory.close();
    }
}
