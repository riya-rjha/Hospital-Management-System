package cg.hospital.repository;

import cg.hospital.entity.Appointment;
import cg.hospital.projection.AppointmentProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    path = "appointments",
    collectionResourceRel = "appointments",
    excerptProjection = AppointmentProjection.class
)
public interface AppointmentRepository
    extends JpaRepository<Appointment, Integer> {

    Page<Appointment> findByOrderByStartoDesc(
        Pageable pageable
    );

    Page<Appointment> findByPatient(
        @Param("patient") Integer patient,
        Pageable pageable
    );

    Page<Appointment> findByPhysician(
        @Param("physician") Integer physician,
        Pageable pageable
    );
}