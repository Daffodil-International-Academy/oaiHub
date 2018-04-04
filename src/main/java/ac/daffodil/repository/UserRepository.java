package ac.daffodil.repository;

import ac.daffodil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by codin on 3/20/2018.
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
