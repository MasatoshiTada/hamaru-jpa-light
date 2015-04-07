package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerInsertSample2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        try {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerId(3);
            manufacturer.setName("HOGE");
            manager.merge(manufacturer);
            
            manager.flush();
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            e.printStackTrace();
        }
        manager.close();
        factory.close();
    }
}
