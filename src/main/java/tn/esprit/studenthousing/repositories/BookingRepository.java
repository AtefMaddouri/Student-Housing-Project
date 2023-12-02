package tn.esprit.studenthousing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.studenthousing.entities.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {

   @Query("""
           select (count(b) > 0) from Booking b join b.studentList studentList
           where studentList.inc = ?1 and YEAR(b.academicYear) = ?2 """)
   Boolean existsByStudentList_IncAndAcademicYear_Year(long studentList_inc, int academicYear_year);

   @Query("""
           select b from Booking b join b.studentList studentList
           where studentList.inc = ?1 and YEAR(b.academicYear) = ?2 """)
   Booking findByStudentList_IncAndAcademicYear_Year(long studentINC, int year);

   @Query("""
           select b from Booking b 
           join Room r on b member of r.bookingList
           where r.block.studentHousing.university.universityName = :universityName and YEAR(b.academicYear) = :academicYear and b.isValid = true """)
   List<Booking> getBookingsByUniversityNameAndAcademicYear(@Param("universityName") String universityName,@Param("academicYear") int academicYear);
}