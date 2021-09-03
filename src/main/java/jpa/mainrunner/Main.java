package jpa.mainrunner;

import jakarta.persistence.*;
import jpa.entitymodels.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //Student student = new Student();
            //student.setEmail("david.doom@gmail.com");
            //student.setName("David Doom");
            //student.setPassword("123456");
            //entityManager.persist(student);

            TypedQuery<Student> query = entityManager.createNamedQuery("getStudentByEmailQuery", Student.class);
            query.setParameter("emailValue", "wasin_sanguansuk@hotmail.com");
            List<Student> studentList = query.getResultList();
            for (Student s : studentList) {
                System.out.println(s);
            }

            System.out.println("----------");

            Query query2 = entityManager.createNativeQuery("SELECT COUNT(*) FROM Student INNER JOIN Student_Course SC ON Student.email = SC.student_email");
            System.out.println(query2.getResultList());

            System.out.println("----------");

            Query query3 = entityManager.createNativeQuery("SELECT Student.* FROM Student INNER JOIN Student_Course SC ON Student.email = SC.student_email");
            for (Object o : query3.getResultList()) {
                System.out.println(o);
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
