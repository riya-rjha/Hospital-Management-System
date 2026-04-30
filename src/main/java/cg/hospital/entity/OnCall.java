package cg.hospital.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "On_Call")
public class OnCall {

    // On_Call has a composite primary key (Nurse, BlockFloor, BlockCode, OnCallStart, OnCallEnd)
    @EmbeddedId
    private OnCallId id;

    @Column(name = "OnCallStart", nullable = false)
    private LocalDateTime onCallStart;

    @Column(name = "OnCallEnd", nullable = false)
    private LocalDateTime onCallEnd;

    // Link back to Nurse — read only, just for display
    @ManyToOne
    @MapsId("nurse")
    @JoinColumn(name = "Nurse")
    private Nurse nurse;

    public OnCall() {}

    public OnCallId getId()                     { return id; }
    public void setId(OnCallId id)              { this.id = id; }

    public LocalDateTime getOnCallStart()       { return onCallStart; }
    public void setOnCallStart(LocalDateTime t) { this.onCallStart = t; }

    public LocalDateTime getOnCallEnd()         { return onCallEnd; }
    public void setOnCallEnd(LocalDateTime t)   { this.onCallEnd = t; }

    public Nurse getNurse()                     { return nurse; }
    public void setNurse(Nurse n)               { this.nurse = n; }
}