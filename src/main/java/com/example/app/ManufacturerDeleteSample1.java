package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerDeleteSample1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(1);
        manufacturer.setName("FUGA");
        System.out.println("merge start.");
        Manufacturer managedManufacturer =  manager.merge(manufacturer);
        System.out.println("merge end.");
        System.out.println("remove start.");
        manager.remove(managedManufacturer);
        System.out.println("remove end.");
        
        System.out.println("flush start.");
        manager.flush();
        System.out.println("flush end.");
        System.out.println("commit start.");
        tx.commit();
        System.out.println("commit end.");
        
        manager.close();
        factory.close();
    }
}
