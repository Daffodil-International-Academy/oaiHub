package ac.daffodil;

import ac.daffodil.dao.ExamDao;
import ac.daffodil.model.Exam;
import ac.daffodil.repository.ExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineacademicinformationhubApplication implements CommandLineRunner {
	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	ExamDao examDao;

	public static void main(String[] args) {
		SpringApplication.run(OnlineacademicinformationhubApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

//			saveExam
//			Exam exam=examDao.save(new Exam("PEC","Acc","2001"));
//			logger.info("Inssssssssserted :",exam);
//			System.out.println(exam);


		//FindExam
		//System.out.println(examDao.find(1L));






	}
}
