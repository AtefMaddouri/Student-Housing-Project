package tn.esprit.studenthousing.services;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.esprit.studenthousing.entities.Booking;
import tn.esprit.studenthousing.entities.Room;
import tn.esprit.studenthousing.entities.Student;
import tn.esprit.studenthousing.repositories.BookingRepository;
import tn.esprit.studenthousing.repositories.RoomRepository;
import tn.esprit.studenthousing.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IBookingServiceImp implements IBookingService{

    private final BookingRepository bookingRepository;
    private final IRoomService roomService;

    private final IStudentService studentService;


    private String generateBookingId(long roomNbr, String blockName, int academicYear) {
        return roomNbr+blockName+academicYear;
    }
    @Transactional
    @Override
    public Booking BookARoom(long roomNbr, long studentINC) {

        Assert.isTrue(!bookingRepository.existsByStudentList_IncAndAcademicYear_Year(studentINC, LocalDate.now().getYear()),
                "you have already booked a room for this year");

        Student student = studentService.findByINC(studentINC);
        Room room = roomService.findByRoomNbr(roomNbr);
        String booking_id = generateBookingId(roomNbr, room.getBlock().getBlockName(), LocalDate.now().getYear());

        //we search if there is already a booking for this year or else we create new one
        //we search by id because we cannot have two booking of same room that has the same id
        // (because the id contains already roomNbr+blockName+academicYear )
        Booking booking = bookingRepository.findById(booking_id).orElse(Booking.builder()
                                                                               .id(booking_id)
                                                                               .academicYear(LocalDate.now())
                                                                               .isValid(true)
                                                                               .studentList(new ArrayList<>())
                                                                               .build());
        // we verify if the room is available
        Assert.isTrue(booking.getIsValid()," this room is no more available (room with number: "+roomNbr +")");
        booking.getStudentList().add(student);

        //if the booking object is new then we added to the booking list of the room
        if(!room.getBookingList().contains(booking)){
            booking = bookingRepository.save(booking);
            room.getBookingList().add(booking);
        }

        //finally we update the availability of the room
        switch (room.getRoomType()){
            case SIMPLE -> booking.setIsValid(false);
            case DOUBLE -> { if(booking.getStudentList().size()==2) booking.setIsValid(false);}
            case TRIPLE -> { if(booking.getStudentList().size()==3) booking.setIsValid(false);}
        }

        return booking;
    }

    @Override
    public String unBook(long studentINC) {
        Assert.isTrue(bookingRepository.existsByStudentList_IncAndAcademicYear_Year(studentINC, LocalDate.now().getYear()),
                "you have not yet booked a room for this year");

        Student student = studentService.findByINC(studentINC);
        Booking booking = bookingRepository.findByStudentList_IncAndAcademicYear_Year(studentINC, LocalDate.now().getYear());

        booking.getStudentList().remove(student);
        bookingRepository.save(booking);
        if(!booking.getStudentList().isEmpty()) {
            booking.setIsValid(true);
            bookingRepository.save(booking);
        }else {
            roomService.detachBooking(booking);
            bookingRepository.delete(booking);
        }

        return "you have successfully unbooked your room";
    }

    @Override
    public List<Booking> getBookingsByUniversityNameAndAcademicYear(String universityName, int academicYear) {
        return bookingRepository.getBookingsByUniversityNameAndAcademicYear(universityName, academicYear);
    }


}
