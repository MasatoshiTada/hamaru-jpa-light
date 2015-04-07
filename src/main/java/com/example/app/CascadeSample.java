package com.example.app;

import com.example.entity.Department;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CascadeSample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("samplePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Department d = em.find(Department.class, 1);
        em.remove(d);
        
        tx.commit();
        em.close();
        emf.close();
    }
    
}
