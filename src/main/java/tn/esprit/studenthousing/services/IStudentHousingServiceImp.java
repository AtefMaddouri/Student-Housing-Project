package tn.esprit.studenthousing.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.studenthousing.repositories.StudentHousingRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class IStudentHousingServiceImp implements IStudentHousingService{

    private final StudentHousingRepository studentHousingRepository;

    @Override
    @Scheduled(fixedRate = 30000)
    @Transactional(readOnly = true)
    public void blockListLazyFetchingScheduled() {

        studentHousingRepository.findById(1l)
                .map(StudentHousingDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("no student housing found with this id : "+1))
                .getBlockList()
                .forEach(block -> log.info("block: {} has: {} rooms",block.getBlockName(),block.getRoomList().size()));
    }


}
