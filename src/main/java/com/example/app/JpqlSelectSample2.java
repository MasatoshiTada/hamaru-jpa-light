package com.example.app;

import com.example.entity.Manufacturer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpqlSelectSample2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        String jpql = "select m from manufacturer m "
            + "where m.name like :name";
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
