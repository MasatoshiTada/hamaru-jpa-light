/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.app;

import com.example.entity.Manufacturer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Tada
 */
public class RemoveAndDetachSample {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Manufacturer manufacturer = manager.find(Manufacturer.class, 1);
        
        manager.remove(manufacturer);
        manager.detach(manufacturer);
        
        manager.flush();
        tx.commit();
        
        manager.close();
        factory.close();
    }
}
