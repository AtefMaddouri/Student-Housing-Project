package tn.esprit.studenthousing.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.studenthousing.entities.Block;

import java.util.List;

public interface IStudentHousingService {

    @Scheduled(fixedRate = 30000)
        @Transactional(readOnly = true)
    void blockListLazyFetchingScheduled();
}
