package tn.esprit.studenthousing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.studenthousing.entities.Block;
import tn.esprit.studenthousing.services.IStudentHousingService;

import java.util.List;

@RestController
@RequestMapping("student-housing")
@RequiredArgsConstructor
public class StudentHousingRestController {

    private final IStudentHousingService iStudentHousingService;

}
