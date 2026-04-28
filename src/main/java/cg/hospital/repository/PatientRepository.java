package cg.hospital.repository;

import cg.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;



@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Exposed at: GET /api/patients/search/findByPcpEmployeeId?employeeId=1
    List<Patient> findByPcp_EmployeeId(Integer employeeId);

}