package tn.esprit.studenthousing.services;

import org.springframework.data.domain.Page;
import tn.esprit.studenthousing.entities.Booking;
import tn.esprit.studenthousing.entities.Room;
import tn.esprit.studenthousing.entities.RoomType;

import java.util.List;

public interface IRoomService {

    Room addRoom(Room room);
    Room findByRoomNbr(long roomNbr);
    Boolean isStillAvailable(long roomNbr);
    List<Room> getAllAvailableRoomsByUniversityNameAndRoomType(String universityName, RoomType roomType);

    Page<Room> getAllRooms(int pageNbr,int pageSize);

    List<Room> getAllRommsByBlockIdAndRoomType(long blocID, RoomType roomType);

    void detachBooking(Booking booking);
}
