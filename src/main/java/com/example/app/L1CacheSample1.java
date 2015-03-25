package com.example.app;

import com.example.entity.Manufacturer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class L1CacheSample1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        
        Manufacturer m01 = manager.find(Manufacturer.class, 1);
        Manufacturer m02 = manager.find(Manufacturer.class, 19941212);
        
        String jpql = "SELECT m FROM Manufacturer m ORDER BY m.manufacturerId";
        TypedQuery<Manufacturer> query = manager.createQuery(jpql, Manufacturer.class);
        System.out.println(query.getClass().getName());
        
        List<Manufacturer> list = query.getResultList();
        Manufacturer m11 = list.get(0);
        Manufacturer m12 = list.get(1);
        
        if (m01 == m11) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
        
        if (m02 == m12) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
        
        manager.close();
        factory.close();
    }
}
