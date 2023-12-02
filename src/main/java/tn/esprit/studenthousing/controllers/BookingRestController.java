package tn.esprit.studenthousing.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studenthousing.entities.Booking;
import tn.esprit.studenthousing.services.IBookingService;

import java.util.List;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingRestController {

    private final IBookingService bookingService;

    @PostMapping("{roomNbr}/{StudentINC}")
    public Booking BookARoom(@PathVariable long roomNbr, @PathVariable long StudentINC ){
        return bookingService.BookARoom(roomNbr,StudentINC);
    }

    @PutMapping("{StudentINC}")
    public String unBook(@PathVariable long StudentINC ){
        return bookingService.unBook(StudentINC);
    }

    @Operation(description = "get all bookings By university_Name And academic_Year")
    @GetMapping("{universityName}/{academicYear}")
    public List<Booking> getBookingsByUniversityNameAndAcademicYear(@PathVariable String universityName, @PathVariable int academicYear){
        return bookingService.getBookingsByUniversityNameAndAcademicYear(universityName, academicYear);
    }



}
