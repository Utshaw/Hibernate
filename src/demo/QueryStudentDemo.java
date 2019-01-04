package demo;

import entity.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
    
    private static void displayStudents(List<Student> studentList){
        
        for(Student tempStudent: studentList){
                System.out.println(tempStudent);
            }
    }
    
    public static void main(String[] args) {
         // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {
           
            // start a transaction
            session.beginTransaction();
           
            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            
            // display the students
            displayStudents(theStudents);
            
            // query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            // display the students
            System.out.println("Student whose last name is Doe");
            displayStudents(theStudents);
            
           
            
            // commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done!");
            
            
            
            
        } finally  {
            factory.close();
        }
        
    }
}
