package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpqlUpdateSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Manufacturer manufacturer = manager.find(Manufacturer.class, 1);
        
        String jpql = "UPDATE Manufacturer m SET m.name = 'Fuga Corp.' WHERE m.manufacturerId = :id";
        int rows = manager.createQuery(jpql)
                .setParameter("id", 1)
                .executeUpdate();
        
        manager.flush();
        tx.commit();
        
        System.out.println(rows + "行を更新しました。");
        System.out.println(manufacturer.getName());
        
        manager.close();
        factory.close();
    }
}
