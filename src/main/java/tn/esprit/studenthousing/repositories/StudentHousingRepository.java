package tn.esprit.studenthousing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.studenthousing.entities.StudentHousing;

public interface StudentHousingRepository extends JpaRepository<StudentHousing, Long> {
}