package tn.esprit.studenthousing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.studenthousing.entities.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByInc(long inc);
}