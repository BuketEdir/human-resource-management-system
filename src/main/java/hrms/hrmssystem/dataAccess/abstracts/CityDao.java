package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
