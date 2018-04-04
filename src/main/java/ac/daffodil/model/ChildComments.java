package ac.daffodil.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by Bithi on 4/4/2018.
 */
@Entity
public class ChildComments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ccomments_id;


    private String sub_comments;

    @ManyToOne
    private Comments comments;

    public ChildComments() {
    }

    public ChildComments(String sub_comments) {
        this.sub_comments = sub_comments;
    }

    public Long getSub_comments_id() {
        return ccomments_id;
    }

    public void setSub_comments_id(Integer sub_comments_id) {
        this.ccomments_id = ccomments_id;
    }

    public String getSub_comments() {
        return sub_comments;
    }

    public void setSub_comments(String sub_comments) {
        this.sub_comments = sub_comments;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Long getCcomments_id() {
        return ccomments_id;
    }

    public void setCcomments_id(Long ccomments_id) {
        this.ccomments_id = ccomments_id;
    }
    //    public Comments getComments() {
//        return comments;
//    }
//
//    public void setComments(Comments comments) {
//        this.comments = comments;
//    }

    @Override
    public String toString() {
        return "ChildComments{" +
                "ccomments_id=" + ccomments_id +
                ", sub_comments='" + sub_comments + '\'' +
                ", comments=" + comments +
                '}';
    }
}
