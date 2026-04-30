package cg.hospital.repository;

import cg.hospital.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(
    collectionResourceRel = "physicians",
    path = "physicians"
)
public interface PhysicianRepository
    extends JpaRepository<Physician, Integer> {

    List<Physician> findByName(
        @Param("name") String name
    );

    List<Physician> findByPosition(
        @Param("position") String position
    );
}