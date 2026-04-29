package cg.hospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @Column(name = "RoomNumber", nullable = false)
    private Integer roomNumber;

    @Column(name = "RoomType", nullable = false, length = 30)
    private String roomType;

    @Column(name = "BlockFloor", nullable = false, insertable = false, updatable = false)
    private Integer blockFloor;

    @Column(name = "BlockCode", nullable = false, insertable = false, updatable = false)
    private Integer blockCode;

    @Column(name = "Unavailable", nullable = false)
    private Boolean unavailable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor", nullable = false),
        @JoinColumn(name = "BlockCode",  referencedColumnName = "BlockCode",  nullable = false)
    })
    private Block block;

    public Room() {}

    public Room(Integer roomNumber, String roomType, Boolean unavailable, Block block) {
        this.roomNumber  = roomNumber;
        this.roomType    = roomType;
        this.unavailable = unavailable;
        this.block       = block;
        if (block != null && block.getId() != null) {
            this.blockFloor = block.getId().getBlockFloor();
            this.blockCode  = block.getId().getBlockCode();
        }
    }

    public Integer getRoomNumber()  { return roomNumber; }
    public void setRoomNumber(Integer roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomType()     { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public Integer getBlockFloor()  { return blockFloor; }
    public void setBlockFloor(Integer blockFloor) { this.blockFloor = blockFloor; }

    public Integer getBlockCode()   { return blockCode; }
    public void setBlockCode(Integer blockCode) { this.blockCode = blockCode; }

    public Boolean getUnavailable() { return unavailable; }
    public void setUnavailable(Boolean unavailable) { this.unavailable = unavailable; }

    public Block getBlock()         { return block; }
    public void setBlock(Block block) {
        this.block = block;
        if (block != null && block.getId() != null) {
            this.blockFloor = block.getId().getBlockFloor();
            this.blockCode  = block.getId().getBlockCode();
        }
    }
}