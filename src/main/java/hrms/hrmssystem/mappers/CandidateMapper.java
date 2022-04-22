package hrms.hrmssystem.mappers;

import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateMapper {
    public CandidateDto entityToDto(Candidate entity){
        CandidateDto dto=new CandidateDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setNationalityNo(entity.getNationalityNo());
        dto.setBirthDate(entity.getBirthDate());
        dto.setCandidateEmail(entity.getCandidateEmail());
        return dto;
    }
    public List<CandidateDto> entityListToDtoList(List<Candidate> candidateEntity){
        List<CandidateDto> candidateDtoList=new ArrayList<>();
        for (Candidate candidate:candidateEntity){
            CandidateDto candidateDto=new CandidateDto(
                    candidate.getId(),
                    candidate.getFirstName(),
                    candidate.getLastName(),
                    candidate.getNationalityNo(),
                    candidate.getCandidateEmail(),
                    candidate.getBirthDate()
            );
            candidateDtoList.add(candidateDto);
        }
        return  candidateDtoList;
    }
    public Candidate dtoToEntity(CandidateDto dto){
        Candidate entity=new Candidate();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setNationalityNo(entity.getNationalityNo());
        entity.setBirthDate(entity.getBirthDate());
        entity.setCandidateEmail(entity.getCandidateEmail());
        return entity;
    }
}
