


package com.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App
{
    public static void main( String[] args )
    {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        
        createStudent(sessionFactory);
        readStudent(sessionFactory,1);
        updateStudent(sessionFactory,2,"Rahul",63);
        deleteStudent(sessionFactory,1);
        createStudent(sessionFactory);

        sessionFactory.close();
    }
        
    public static void createStudent(SessionFactory sessionFactory){
        
        Session session = sessionFactory.openSession();
        Student stud1 = new Student();
        
        stud1.setId(1);
        stud1.setName("Sidharth");
        stud1.setRoll_no(42);

        session.beginTransaction();
        session.save(stud1);
        session.getTransaction().commit();
        System.out.println("Student row created");
        session.close();
    }

    public static void readStudent(SessionFactory sessionFactory, int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student stud2 =session.get(Student.class,id);
        if(stud2==null){
            System.out.println("Student record not found !");
        }    
        else{
            System.out.println("Student with name " + stud2.getName() + " found");
        }
        session.getTransaction().commit();
        session.close();
    }
        
    public static void updateStudent(SessionFactory sessionFactory, int id, String newName,int newRollno){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Student stud3 = session.get(Student.class, id);
        if(stud3 ==null){
            System.out.println("Student record not found !");
        }  
        else{
            stud3.setName(newName);
            stud3.setRoll_no(newRollno);
            session.update(stud3);
            System.out.println("Student record updated successfully" );
        }

        session.getTransaction().commit();
        session.close();

    }

    public static void deleteStudent(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Student stud4 = session.get(Student.class, id);
        if (stud4 == null) {
            System.out.println("Student record not found for deletion!");
            
        } else {
            session.delete(stud4);
            System.out.println("Student record deleted successfully!");
        }
        
        session.getTransaction().commit();
        session.close();
    }
}










//IGNORE THE FOLLOWING CODE, KEPT FOR REFERENCE

// package com.hibernate;


// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.cfg.Configuration;


// public class App 
// {
//     public static void main( String[] args )
//     {

//         Configuration configuration = new Configuration();
//         configuration.configure("hibernate.cfg.xml");
//         configuration.addAnnotatedClass(Student.class);
//         SessionFactory sessionFactory = configuration.buildSessionFactory();
//         Session session = sessionFactory.openSession();
        


//         Student stud1 = new Student();
        
//         stud1.setId(1);
//         stud1.setName("Sidharth");
//         stud1.setRoll_no(42);

//         session.beginTransaction();
//         session.save(stud1);
//         session.getTransaction().commit();
//         System.out.println("Student row updated");
//         session.close();
//         sessionFactory.close();

//     }
// }

