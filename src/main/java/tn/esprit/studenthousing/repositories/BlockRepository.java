package tn.esprit.studenthousing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.studenthousing.entities.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
}