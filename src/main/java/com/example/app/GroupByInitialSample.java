package com.example.app;

import com.example.entity.Manufacturer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GroupByInitialSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        String jpql = "SELECT SUBSTRING(m.name, 1, 1), COUNT(m) FROM Manufacturer m GROUP BY SUBSTRING(m.name, 1, 1)";
        List<Object[]> list = manager.createQuery(jpql, Object[].class).getResultList();
        for (Object[] array : list) {
            System.out.println(array[0] + ":" + array[1]);
        }
        
//        String jpql = "SELECT m FROM Manufacturer m WHERE m.manufacturerId = 19985678";
//        Manufacturer manufacturer = manager.createQuery(jpql, Manufacturer.class).getSingleResult();
//        System.out.println(manufacturer.getName());
        
        manager.close();
        factory.close();
    }
}
