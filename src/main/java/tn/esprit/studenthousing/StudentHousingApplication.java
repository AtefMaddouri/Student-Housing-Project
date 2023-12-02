package tn.esprit.studenthousing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentHousingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentHousingApplication.class, args);
    }

}
