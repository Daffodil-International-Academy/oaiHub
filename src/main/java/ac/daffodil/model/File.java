package ac.daffodil.model;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by Bithy on 3/21/2018.
 */
@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
    private Integer file_id;

    @Column(name = "exam_id")

    private Integer exam_id;

    @Column(name = "file_type")
    private String file_type;

    @Column(name = "file_name")
    private String file_name;


    @Column(name ="file" )
    private Blob file;

    @Column(name = "subject_name")
    private String subject_name;


    public File() {
    }

    public File(Integer exam_id, String file_type, String file_name, Blob file, String subject_name) {
        this.exam_id = exam_id;
        this.file_type = file_type;
        this.file_name = file_name;
        this.file = file;
        this.subject_name = subject_name;
    }

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }

    public Integer getExam_id() {
        return exam_id;
    }

    public void setExam_id(Integer exam_id) {
        this.exam_id = exam_id;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    @Override
    public String toString() {
        return "File{" +
                "file_id=" + file_id +
                ", exam_id=" + exam_id +
                ", file_type='" + file_type + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file=" + file +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }
}
