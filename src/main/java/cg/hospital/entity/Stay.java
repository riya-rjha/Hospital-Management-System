package cg.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Stay records a patient's hospital stay in a specific room.
// This is the bridge between Patient and Room — the patient detail page
// uses Stay to show: which room the patient was in, which block, and dates.
//
// StayID is a simple integer PK (not composite).
// Patient is stored as raw Integer FK (consistent with how Appointment does it).
// Room is a @ManyToOne join to the Room entity.

@Entity
@Table(name = "Stay")
public class Stay {

    @Id
    @Column(name = "StayID", nullable = false)
    private Integer stayId;

    // Raw FK — consistent with how Appointment stores patient (as Integer)
    @Column(name = "Patient", nullable = false)
    private Integer patient;

    // Room join — gives us roomType and block info for the detail page
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Room", referencedColumnName = "RoomNumber", nullable = false)
    private Room room;

    @Column(name = "StayStart", nullable = false)
    private LocalDateTime stayStart;

    @Column(name = "StayEnd", nullable = false)
    private LocalDateTime stayEnd;

    public Stay() {}

    public Stay(Integer stayId, Integer patient, Room room,
                LocalDateTime stayStart, LocalDateTime stayEnd) {
        this.stayId    = stayId;
        this.patient   = patient;
        this.room      = room;
        this.stayStart = stayStart;
        this.stayEnd   = stayEnd;
    }

    public Integer getStayId()        { return stayId; }
    public void setStayId(Integer stayId) { this.stayId = stayId; }

    public Integer getPatient()       { return patient; }
    public void setPatient(Integer patient) { this.patient = patient; }

    public Room getRoom()             { return room; }
    public void setRoom(Room room) { this.room = room; }

    public LocalDateTime getStayStart() { return stayStart; }
    public void setStayStart(LocalDateTime stayStart) { this.stayStart = stayStart; }

    public LocalDateTime getStayEnd()   { return stayEnd; }
    public void setStayEnd(LocalDateTime stayEnd) { this.stayEnd = stayEnd; }
}