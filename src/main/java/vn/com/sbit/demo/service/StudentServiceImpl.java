package vn.com.sbit.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.sbit.demo.dao.StudentRepository;
import vn.com.sbit.demo.entity.Student;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
//    private StudentDAO studentDAO; - DAO rat ton thoi gian - cong suc
    private StudentRepository studentReponsitory;


    @Autowired
    public StudentServiceImpl(StudentRepository studentReponsitory) {
        this.studentReponsitory = studentReponsitory;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentReponsitory.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentReponsitory.getReferenceById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentReponsitory.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentReponsitory.saveAndFlush(student);
    }
    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentReponsitory.deleteById(id);
    }

}
