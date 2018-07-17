package ac.daffodil.model;

import javax.persistence.*;

/**
 * Created by Muiduzzaman Lipu on 19-May-18.
 */
@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="university_id")
    private Long universityId;

    @Column(name="university_name")
    private String universityName;

    @Column(name="status")
    private String status;

    @Column(name="location")
    private String location;

    @Column(name="total_student")
    private Long totalStudent;

    @Column(name="about", columnDefinition = "TEXT")
    private String about;

    @Column(name="academic_staff")
    private Long academicStaff;

    @Column(name="administrative_staff")
    private Long administrativeStaff;

    @Column(name="undergraduates")
    private Long undergraduates;

    @Column(name="postgraduates")
    private Long postgraduates;

    public University() {
    }

    public University(String universityName, String status, String location, Long totalStudent, String about, Long academicStaff, Long administrativeStaff, Long undergraduates, Long postgraduates) {
        this.universityName = universityName;
        this.status = status;
        this.location = location;
        this.totalStudent = totalStudent;
        this.about = about;
        this.academicStaff = academicStaff;
        this.administrativeStaff = administrativeStaff;
        this.undergraduates = undergraduates;
        this.postgraduates = postgraduates;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Long totalStudent) {
        this.totalStudent = totalStudent;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getAcademicStaff() {
        return academicStaff;
    }

    public void setAcademicStaff(Long academicStaff) {
        this.academicStaff = academicStaff;
    }

    public Long getAdministrativeStaff() {
        return administrativeStaff;
    }

    public void setAdministrativeStaff(Long administrativeStaff) {
        this.administrativeStaff = administrativeStaff;
    }

    public Long getUndergraduates() {
        return undergraduates;
    }

    public void setUndergraduates(Long undergraduates) {
        this.undergraduates = undergraduates;
    }

    public Long getPostgraduates() {
        return postgraduates;
    }

    public void setPostgraduates(Long postgraduates) {
        this.postgraduates = postgraduates;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", totalStudent=" + totalStudent +
                ", about='" + about + '\'' +
                ", academicStaff=" + academicStaff +
                ", administrativeStaff=" + administrativeStaff +
                ", undergraduates=" + undergraduates +
                ", postgraduates=" + postgraduates +
                '}';
    }
}
