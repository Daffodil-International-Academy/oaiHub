package ac.daffodil.repository;

import ac.daffodil.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Bithi on 3/25/2018.
 */
public interface FileRepository extends JpaRepository<File,Long> {
    @Query(value = "SELECT * FROM FILE WHERE FILE_TYPE = :fileType AND SUBJECT_NAME = :subjectName AND YEAR = :year", nativeQuery = true)
    List<File> searchFileManual(@Param("fileType") String fileType, @Param("subjectName") String subjectName, @Param("year") String year);
}
