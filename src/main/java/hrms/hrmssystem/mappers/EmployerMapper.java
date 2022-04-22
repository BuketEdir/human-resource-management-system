package hrms.hrmssystem.mappers;

import hrms.hrmssystem.entities.concretes.Employer;
import hrms.hrmssystem.entities.dtos.EmployerDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerMapper {

    public EmployerDto entityToDto(Employer entity){
        EmployerDto dto=new EmployerDto();
        dto.setId(entity.getId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setWebSite(entity.getWebSite());
        dto.setTelNo(entity.getTelNo());
        dto.setEmployerEmail(entity.getEmployerEmail());
        return dto;
    }


}
