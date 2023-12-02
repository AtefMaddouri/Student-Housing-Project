package tn.esprit.studenthousing.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.studenthousing.entities.Block;
import tn.esprit.studenthousing.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    Student addStudent(Student student);

    Student findByINC(long inc);

    Page<Student> getAllStudents(int pageNbr, int pageSize);
}
