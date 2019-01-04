/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author utshaw
 */
public class CreateStudentDemo {
    
    public static void main(String[] args) {
        
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Farhan", "Utshaw", "farhan.tanvir.utshaw@gmail.com");
            
            
            // start a transaction
            session.beginTransaction();
            
            
            // save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);
            
            // commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done!");
            
            
            
            
        } finally  {
            factory.close();
        }
        
        
        
    }
    
}
