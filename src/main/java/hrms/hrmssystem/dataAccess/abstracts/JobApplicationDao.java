package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationDao extends JpaRepository<JobApplication,Integer> {

   // List<JobApplication> getByJobAnnouncementId(int id);
  //  List<JobApplication> getJobApplicationsByCandidateId(int id);

}
