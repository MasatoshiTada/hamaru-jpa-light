package com.example.app;

import com.example.entity.Manufacturer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class L1CacheSample1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        
        Manufacturer m2 = manager.find(Manufacturer.class, 1);
        System.out.println(m2.hashCode());
        
        String jpql = "SELECT m FROM Manufacturer m ORDER BY m.manufacturerId";
        List<Manufacturer> list = manager.createQuery(jpql, Manufacturer.class)
                .getResultList();
        Manufacturer m1 = list.get(0);
        System.out.println(m1.hashCode());
        
//        Manufacturer m2 = manager.find(Manufacturer.class, 1);
        
        if (m1 == m2) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
        
        manager.close();
        factory.close();
    }
}
