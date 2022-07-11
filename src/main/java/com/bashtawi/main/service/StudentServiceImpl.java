package com.bashtawi.main.service;

import com.bashtawi.main.dao.StudentsDAO;
import com.bashtawi.main.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{

    private StudentsDAO studentsDAO;

    @Autowired
    public StudentServiceImpl(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @Override
    @Transactional
    public List<Students> findAll() {
        return studentsDAO.findAll();
    }

    @Override
    @Transactional
    public Students findById(int studentId) {
        return studentsDAO.findById(studentId);
    }

    @Override
    @Transactional
    public void save(Students students) {
        studentsDAO.save(students);
    }

    @Override
    @Transactional
    public void deleteById(int studentId) {
        studentsDAO.deleteById(studentId);
    }
}
