package tn.esprit.studenthousing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.studenthousing.entities.Room;
import tn.esprit.studenthousing.entities.RoomType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNbr(long roomNbr);
    List<Room> findByBlockIdAndRoomType(long blocID, RoomType roomType);

    @Query("select r from Room r where r.block.id = :block_id and r.roomType = :room_type")
    List<Room> findByBlockIdAndRoomTypeJPQL(@Param("block_id") long block_id, @Param("room_type") RoomType room_type);
    Optional<Room> findByBookingListId(String id);

    List<Room> findByRoomTypeAndBlock_StudentHousing_University_UniversityNameAndBookingList_IsValidAndBookingList_AcademicYear_Between(RoomType roomType, String block_studentHousing_university_universityName, Boolean bookingList_isValid, LocalDate bookingList_academicYear, LocalDate bookingList_academicYear2);


    @Query("""
            select r from Room r
            where r.block.studentHousing.university.universityName = :universityName 
            and r.roomType = :roomType
            and r not in (select r from Room r join Booking b on b member of r.bookingList
            and year(b.academicYear) = :academicYear and b.isValid = false)
            """)
    List<Room> getAllAvailableRoomsByUniversityNameAndRoomType(@Param("universityName") String universityName,
                                                               @Param("roomType") RoomType roomType,
                                                               @Param("academicYear") int academicYear);
}