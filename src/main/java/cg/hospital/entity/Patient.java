package cg.hospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @Column(name = "SSN")
    private Integer ssn;

    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "Address", nullable = false, length = 30)
    private String address;

    @Column(name = "Phone", nullable = false, length = 30)
    private String phone;

    @Column(name = "InsuranceID", nullable = false)
    private Integer insuranceId;

    // PCP is FK to Physician — ManyToOne because many patients can have same PCP
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PCP", nullable = false)
    private Physician pcp;

    public Patient() {}

    public Patient(Integer ssn, String name, String address,
                   String phone, Integer insuranceId, Physician pcp) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.insuranceId = insuranceId;
        this.pcp = pcp;
    }

    public Integer getSsn() { return ssn; }
    public void setSsn(Integer ssn) { this.ssn = ssn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Integer getInsuranceId() { return insuranceId; }
    public void setInsuranceId(Integer insuranceId) { this.insuranceId = insuranceId; }

    public Physician getPcp() { return pcp; }
    public void setPcp(Physician pcp) { this.pcp = pcp; }
}