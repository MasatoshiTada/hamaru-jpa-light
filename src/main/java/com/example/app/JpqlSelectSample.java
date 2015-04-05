package com.example.app;

import com.example.entity.Manufacturer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpqlSelectSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        String jpql = "SELECT m FROM Manufacturer m "
            + "WHERE m.name LIKE :name";
        TypedQuery<Manufacturer> query = 
            manager.createQuery(jpql, Manufacturer.class);
        query.setParameter("name", "B%");
        List<Manufacturer> list =  query.getResultList();
        for (Manufacturer m : list) {
            System.out.println(m.getManufacturerId() + ":" + m.getName());
        }
        manager.close();
        factory.close();
    }
}
