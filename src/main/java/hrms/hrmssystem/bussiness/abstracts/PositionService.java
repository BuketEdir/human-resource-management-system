package hrms.hrmssystem.bussiness.abstracts;

import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import hrms.hrmssystem.entities.concretes.Position;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.entities.dtos.PositionDto;

import javax.print.DocFlavor;
import java.util.List;

public interface PositionService {

    DataResult<List<Position>> getAll();
    Result add(PositionDto positionDto);
    Result delete(PositionDto positionDto);

    Result update(PositionDto positionDto);

    //DataResult<Position> getByPositionName(String positionName);

    SuccessDataResult<PositionDto> findByPositionName(String positionName);

}

