package cg.hospital.repository;

import cg.hospital.entity.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "stays", path = "stays")
public interface StayRepository extends JpaRepository<Stay, Integer> {

    // GET /api/stays/search/findByPatient?patient={ssn}
    // Used on patient detail page (Page 3) to show room + block info
    List<Stay> findByPatient(Integer patientSsn);
}