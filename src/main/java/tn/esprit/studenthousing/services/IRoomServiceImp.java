package tn.esprit.studenthousing.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.studenthousing.entities.Booking;
import tn.esprit.studenthousing.entities.Room;
import tn.esprit.studenthousing.entities.RoomType;
import tn.esprit.studenthousing.repositories.RoomRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IRoomServiceImp implements IRoomService{

    private final RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findByRoomNbr(long roomNbr) {
        return roomRepository.findByRoomNbr(roomNbr)
                .orElseThrow(() -> new IllegalArgumentException("no room found with this number: "+roomNbr));
    }

    @Override
    public Boolean isStillAvailable(long roomNbr) {
        return null;
    }

    @Override
    public List<Room> getAllAvailableRoomsByUniversityNameAndRoomType(String universityName, RoomType roomType) {
        return roomRepository.getAllAvailableRoomsByUniversityNameAndRoomType(universityName, roomType,LocalDate.now().getYear());
    }

    @Override
    public Page<Room> getAllRooms(int pageNbr,int pageSize) {
        return roomRepository.findAll(PageRequest.of(pageNbr,pageSize));
    }

    @Override
    public List<Room> getAllRommsByBlockIdAndRoomType(long blocID, RoomType roomType) {
       // roomRepository.findByBlockIdAndRoomTypeJPQL(blocID, roomType);
        return roomRepository.findByBlockIdAndRoomType(blocID,roomType);
    }

    @Override
    public void detachBooking(Booking booking) {
        roomRepository.findByBookingListId(booking.getId())
                .get()
                .getBookingList().remove(booking);
    }
}
