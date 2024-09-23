package vn.com.sbit.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.sbit.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
