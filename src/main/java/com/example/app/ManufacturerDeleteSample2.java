package com.example.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerDeleteSample2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        String jpql = "DELETE FROM Manufacturer m WHERE m.manufacturerId = :id";
        int rows = manager.createQuery(jpql)
                .setParameter("id", 99999999)
                .executeUpdate();
        
        manager.flush();
        tx.commit();
        
        System.out.println(rows + "行を削除しました。");
        
        manager.close();
        factory.close();
    }
}
