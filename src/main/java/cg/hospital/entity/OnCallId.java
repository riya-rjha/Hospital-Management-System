package cg.hospital.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OnCallId implements Serializable {

    @Column(name = "Nurse")
    private Integer nurse;

    @Column(name = "BlockFloor")
    private Integer blockFloor;

    @Column(name = "BlockCode")
    private Integer blockCode;

    public OnCallId() {}

    public OnCallId(Integer nurse, Integer blockFloor, Integer blockCode) {
        this.nurse      = nurse;
        this.blockFloor = blockFloor;
        this.blockCode  = blockCode;
    }

    public Integer getNurse()                 { return nurse; }
    public void setNurse(Integer n)           { this.nurse = n; }

    public Integer getBlockFloor()            { return blockFloor; }
    public void setBlockFloor(Integer f)      { this.blockFloor = f; }

    public Integer getBlockCode()             { return blockCode; }
    public void setBlockCode(Integer c)       { this.blockCode = c; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OnCallId)) return false;
        OnCallId that = (OnCallId) o;
        return Objects.equals(nurse, that.nurse) &&
               Objects.equals(blockFloor, that.blockFloor) &&
               Objects.equals(blockCode, that.blockCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nurse, blockFloor, blockCode);
    }
}