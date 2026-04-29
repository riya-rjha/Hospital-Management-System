package cg.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

// Composite PK for the Block table.
// Both columns together uniquely identify a hospital block.

@Embeddable
public class BlockId implements Serializable {

    @Column(name = "BlockFloor", nullable = false)
    private Integer blockFloor;

    @Column(name = "BlockCode", nullable = false)
    private Integer blockCode;

    public BlockId() {}

    public BlockId(Integer blockFloor, Integer blockCode) {
        this.blockFloor = blockFloor;
        this.blockCode = blockCode;
    }

    public Integer getBlockFloor() { return blockFloor; }
    public void setBlockFloor(Integer blockFloor) { this.blockFloor = blockFloor; }

    public Integer getBlockCode() { return blockCode; }
    public void setBlockCode(Integer blockCode) { this.blockCode = blockCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlockId)) return false;
        BlockId other = (BlockId) o;
        return Objects.equals(blockFloor, other.blockFloor)
                && Objects.equals(blockCode, other.blockCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockFloor, blockCode);
    }
}