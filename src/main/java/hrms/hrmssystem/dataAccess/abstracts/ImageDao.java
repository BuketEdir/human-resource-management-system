package hrms.hrmssystem.dataAccess.abstracts;

import hrms.hrmssystem.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image,Integer> {

    Image getByCandidateId(int candidateId);}
