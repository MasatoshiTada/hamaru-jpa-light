package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerDeleteSample3 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Manufacturer manufacturer = manager.find(Manufacturer.class, 1);
        
        manager.createQuery("DELETE FROM Manufacturer m WHERE m.manufacturerId = :id")
                .setParameter("id", 1)
                .executeUpdate();
        
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
