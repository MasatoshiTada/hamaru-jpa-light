package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerUpdateSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Manufacturer manufacturer = manager.find(Manufacturer.class, 1);
        manufacturer.setName("FUGA");
        
        System.out.println("flush start.");
        manager.flush();
        System.out.println("flushed.");
        tx.commit();
        System.out.println("committed.");
        
        manager.close();
        factory.close();
    }
}
