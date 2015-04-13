package com.example.app;

import com.example.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BulkInsertBenchmark {
    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("samplePU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        List<Employee> empList = getEmpList(3000);
        
        long start = System.currentTimeMillis();
        
        tx.begin();
        for (Employee emp : empList) {
            manager.persist(emp);
        }
        tx.commit();
        
        long end = System.currentTimeMillis();
        
        System.out.println("time = " + (end - start) + "[ms]");
        
        manager.close();
        factory.close();
    }
    
    private static List<Employee> getEmpList(final int size) {
        List<Employee> empList = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            Employee emp = new Employee();
            emp.setEmpId(i);
            emp.setName("HOGE");
            empList.add(emp);
        }
        return empList;
    }
    
}
