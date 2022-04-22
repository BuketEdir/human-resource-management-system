package hrms.hrmssystem.dataAccess.abstracts;


import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {

    Employer findByEmployerEmail(String employerEmail);



}
