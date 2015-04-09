package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerInsertSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        try {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerId(1);
            manufacturer.setName("HOGE");
            manager.persist(manufacturer);

            manager.flush();
            
            System.out.println(manager.contains(manufacturer));
            
            tx.commit();
            
            System.out.println(manager.contains(manufacturer));

        } catch (Exception e) {
            System.out.println("===========" + e.getClass().getName() + "===========");
            e.printStackTrace();
        }
        manager.close();
        factory.close();
    }
}
