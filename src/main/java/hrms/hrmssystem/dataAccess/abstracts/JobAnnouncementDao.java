package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.JobAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer> {

   // List<JobAnnouncement> getAllByIsActiveTrue();
}
