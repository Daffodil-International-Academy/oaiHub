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

    public University() {
    }

    public University(String universityName, String status, String location) {
        this.universityName = universityName;
        this.status = status;
        this.location = location;
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

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
