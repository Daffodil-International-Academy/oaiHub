package ac.daffodil.model;

/**
 * Created by Bithi on 4/2/2018.
 */

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;

    private String comment_text;

    @CreationTimestamp
    private LocalDateTime date_time;

    @UpdateTimestamp
    private LocalDateTime updated_date_time;

    public Comments() {
    }

    public Comments(String comment_text, LocalDateTime date_time, LocalDateTime updated_date_time) {
        this.comment_text = comment_text;
        this.date_time = date_time;
        this.updated_date_time = updated_date_time;
    }



    public Long getComment_id() {
        return comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

        public LocalDateTime getDate_time() {
        return date_time;
    }

    public LocalDateTime getUpdated_date_time() {
        return updated_date_time;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment_id=" + comment_id +
                ", comment_text='" + comment_text + '\'' +
                ", date_time=" + date_time +
                ", updated_date_time=" + updated_date_time +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Comments{" +
//                "comment_id=" + comment_id +
//                ", comment_text='" + comment_text + '\'' +
//                '}';
//    }
}
