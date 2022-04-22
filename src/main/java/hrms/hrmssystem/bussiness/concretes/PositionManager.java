package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.PositionService;
import hrms.hrmssystem.core.utilities.results.*;
import hrms.hrmssystem.dataAccess.abstracts.PositionDao;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.concretes.Position;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.entities.dtos.PositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionManager implements PositionService {
    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    /*@Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>
                (this.positionDao.findAll(), "List of positions");
    }*/

    @Override
    public DataResult<List<Position>> getAll() {
        List<PositionDto> positionDtoList = positionDao.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Position>>
                (this.positionDao.findAll(), "List of positions");

    }

    private PositionDto convertEntityToDto(Position position) {
        PositionDto positionDto = new PositionDto();
        positionDto.setId(position.getId());
        positionDto.setPositionName(position.getPositionName());

        return positionDto;
    }


    @Override
    public Result add(PositionDto positionDto) {
       Position position=new Position();
       position.setPositionName(positionDto.getPositionName());
       position.setId(positionDto.getId());
       this.positionDao.save(position);
       return new SuccessResult("position added");
    }

    @Override
    public Result delete(PositionDto positionDto) {
        Position position=new Position();
        position.setPositionName(positionDto.getPositionName());
        position.setId(positionDto.getId());
        this.positionDao.delete(position);
        return new SuccessResult("position deleted");

    }

    @Override
    public Result update(PositionDto positionDto) {
        Position position=this.positionDao.getById(positionDto.getId());
        position.setPositionName(positionDto.getPositionName());
        position.setId(positionDto.getId());
        this.positionDao.save(position);
        return new SuccessResult("position updated");

    }


    /*@Override
    public DataResult<Position> getByPositionName(String positionName){
        return new SuccessDataResult<Position>
        (this.positionDao.getByPositionName(positionName),"List of positions");
    }*/


    @Override
       public SuccessDataResult<PositionDto> findByPositionName(String positionName) {
        Position position = positionDao.findByPositionName(positionName);
        PositionDto positionDto = convertEntityToDto(position);
        return new SuccessDataResult<PositionDto>(positionDto);
    }




    private Result isPositionNameExists(String positionName) {
        if (this.positionDao.findByPositionName(positionName) != null) {
            return new ErrorResult("This position is exists");
        } else return new SuccessResult();
    }


}
