package tn.esprit.studenthousing.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.studenthousing.entities.Block;
import tn.esprit.studenthousing.entities.Student;
import tn.esprit.studenthousing.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IStudentServiceImp implements IStudentService{
    private final StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
            return studentRepository.save(student);
    }

    @Override
    public Student findByINC(long inc) {
        return studentRepository.findByInc(inc)
                .orElseThrow(() -> new IllegalArgumentException("no student found with this inc : "+inc));
    }

    @Override
    public Page<Student> getAllStudents(int pageNbr, int pageSize) {
        return studentRepository.findAll(PageRequest.of(pageNbr,pageSize));
    }


}
