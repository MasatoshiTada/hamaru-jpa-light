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
        System.out.println("begin");
        tx.begin();
        
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        manufacturer.setName("Hoge Corp.");
        System.out.println("persist");
        manager.persist(manufacturer);
        
        System.out.println("flush");
        manager.flush();
        System.out.println("commit");
        tx.commit();
        
        manager.close();
        factory.close();
    }
}
