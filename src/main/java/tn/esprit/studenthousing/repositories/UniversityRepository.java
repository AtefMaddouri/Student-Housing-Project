package tn.esprit.studenthousing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.studenthousing.entities.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
}