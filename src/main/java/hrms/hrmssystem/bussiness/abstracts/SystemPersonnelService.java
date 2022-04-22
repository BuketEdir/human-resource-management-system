package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.SystemPersonnel;
import hrms.hrmssystem.entities.dtos.SystemPersonnelDto;

import java.util.List;

public interface SystemPersonnelService {
    DataResult<List<SystemPersonnel>> getAll();
    Result add(SystemPersonnelDto systemPersonnelDto);
    Result delete(SystemPersonnelDto systemPersonnelDto);

    Result update(SystemPersonnelDto systemPersonnelDto);
}
