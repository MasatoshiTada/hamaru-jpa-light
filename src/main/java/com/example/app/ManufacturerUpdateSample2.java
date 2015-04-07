package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerUpdateSample2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("samplePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Manufacturer m = new Manufacturer();
        m.setManufacturerId(1);
        m.setName("FUGA");
        
        System.out.println("merge start.");
        em.merge(m);
        System.out.println("merge end.");
        
        System.out.println("flush start.");
        em.flush();
        System.out.println("flush end.");
        
        System.out.println("commit start.");
        tx.commit();
        System.out.println("commit end.");
        
        em.close();
        emf.close();
    }
}
