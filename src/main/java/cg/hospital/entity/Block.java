package cg.hospital.entity;

import jakarta.persistence.*;
import java.util.List;

// Block represents a physical floor+code section in the hospital.
// PK is composite: (BlockFloor, BlockCode) — modelled with @EmbeddedId.
// Room and OnCall both FK into Block — they are mapped as @OneToMany here
// so the patient detail page can navigate: Patient → Stay → Room → Block.

@Entity
@Table(name = "Block")
public class Block {

    @EmbeddedId
    private BlockId id;

    // Rooms that belong to this block — used when showing patient's room detail
    @OneToMany(mappedBy = "block", fetch = FetchType.LAZY)
    private List<Room> rooms;

    public Block() {}

    public Block(BlockId id) {
        this.id = id;
    }

    public BlockId getId() { return id; }
    public void setId(BlockId id) { this.id = id; }

    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }
}