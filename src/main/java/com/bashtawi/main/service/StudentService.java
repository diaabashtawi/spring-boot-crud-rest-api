package com.bashtawi.main.service;

import com.bashtawi.main.entity.Students;

import java.util.List;


public interface StudentService {

    public List<Students> findAll();

    public Students findById(int studentId);

    public void save(Students students);

    public void deleteById(int studentId);
}
