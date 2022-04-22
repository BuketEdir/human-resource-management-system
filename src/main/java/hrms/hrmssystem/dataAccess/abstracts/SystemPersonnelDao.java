package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {
}
