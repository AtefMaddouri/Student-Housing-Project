package tn.esprit.studenthousing.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studenthousing.entities.Room;
import tn.esprit.studenthousing.entities.RoomType;
import tn.esprit.studenthousing.services.IRoomService;

import java.util.List;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomRestController {

    private final IRoomService roomService;

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping
    public Page<Room> getAllRooms(@RequestParam int pageNbr,@RequestParam int pageSize) {
        return roomService.getAllRooms(pageNbr,pageSize);
    }

    @GetMapping("{roomNbr}")
    public Room findByRoomNbr(@PathVariable long roomNbr) {
        return roomService.findByRoomNbr(roomNbr);
    }

    @Operation(description = "get All Rooms By Block_Id And RoomType")
    @GetMapping("getAllRommsByBlockIdAndRoomType/{blockID}/{roomType}")
    public List<Room> getAllRommsByBlockIdAndRoomType(@PathVariable long blockID, @PathVariable RoomType roomType) {
        return roomService.getAllRommsByBlockIdAndRoomType(blockID, roomType);
    }

    @Operation(description = "get All Available Rooms By University_Name And RoomType in the current academic year")
    @GetMapping("ByUniversityNameAndRoomType/{universityName}/{roomType}")
    public List<Room> getAllAvailableRoomsByUniversityNameAndRoomType(@PathVariable String universityName, @PathVariable RoomType roomType) {
        return roomService.getAllAvailableRoomsByUniversityNameAndRoomType(universityName, roomType);
    }




}