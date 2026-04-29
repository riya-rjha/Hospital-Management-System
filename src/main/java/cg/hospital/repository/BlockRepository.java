package cg.hospital.repository;

import cg.hospital.entity.Block;
import cg.hospital.entity.BlockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "blocks", path = "blocks")
public interface BlockRepository extends JpaRepository<Block, BlockId> {

    // GET /api/blocks/search/findByIdBlockFloor?blockFloor=1
    List<Block> findByIdBlockFloor(Integer blockFloor);
}