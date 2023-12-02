package tn.esprit.studenthousing.services;

import tn.esprit.studenthousing.entities.Booking;

import java.util.List;

public interface IBookingService {
    Booking BookARoom(long roomNbr, long studentINC);

    String unBook(long studentINC);

    List<Booking> getBookingsByUniversityNameAndAcademicYear(String universityName, int academicYear);
}
