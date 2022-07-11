package com.bashtawi.main.dao;

import com.bashtawi.main.entity.Students;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentsDAOHibernateImpl implements StudentsDAO{

    // Define field for EntityManger
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentsDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Students> findAll() {

        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        Query<Students> query =
                session.createQuery("from Students", Students.class);

        // execute query and get result list
        List<Students> students = query.getResultList();

        // return the results
        return students;
    }

    @Override
    public Students findById(int studentId) {

        //Get the Current Hibernate Session
        Session session = entityManager.unwrap(Session.class);

        //Get the Student
        Students student =
                session.get(Students.class, studentId);

        //Return the student
        return student;
    }

    @Override
    public void save(Students students) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(students);

    }

    @Override
    public void deleteById(int studentId) {

        Session session = entityManager.unwrap(Session.class);

        Query query =
                session.createQuery("delete from Students where id=:studentId");

        query.setParameter("studentId", studentId);

        query.executeUpdate();
    }


}
