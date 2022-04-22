package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    //User findByEmail(String email);

}
