package cg.hospital.repository;

import cg.hospital.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomRepository extends JpaRepository<Room, Integer> {

    // GET /api/rooms/search/findByBlockIdBlockFloor?blockFloor=1
    List<Room> findByBlock_IdBlockFloor(Integer blockFloor);

    // GET /api/rooms/search/findByUnavailable?unavailable=false
    List<Room> findByUnavailable(Boolean unavailable);

    // GET /api/rooms/search/findByRoomType?roomType=Single
    List<Room> findByRoomType(String roomType);
}