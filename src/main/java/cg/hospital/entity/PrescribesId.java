package cg.hospital.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PrescribesId {
    @Column(name = "Physician", nullable = false)
    private Integer physician;

    @Column(name = "Patient", nullable = false)
    private Integer patient;

    @Column(name = "Medication", nullable = false)
    private Integer medication;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    public Integer getPhysician() {
        return physician;
    }

    public void setPhysician(Integer physician) {
        this.physician = physician;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getMedication() {
        return medication;
    }

    public void setMedication(Integer medication) {
        this.medication = medication;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.physician);
        hash = 97 * hash + Objects.hashCode(this.patient);
        hash = 97 * hash + Objects.hashCode(this.medication);
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrescribesId other = (PrescribesId) obj;
        if (!Objects.equals(this.physician, other.physician)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        if (!Objects.equals(this.medication, other.medication)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

}
