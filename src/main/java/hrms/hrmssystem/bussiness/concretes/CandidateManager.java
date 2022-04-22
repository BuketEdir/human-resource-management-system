package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.CandidateService;
import hrms.hrmssystem.core.utilities.results.*;
import hrms.hrmssystem.dataAccess.abstracts.CandidateDao;
import hrms.hrmssystem.entities.concretes.Candidate;
import hrms.hrmssystem.entities.dtos.CandidateDto;
import hrms.hrmssystem.mappers.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager<DataResultList> implements CandidateService {

    private CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        super();
        this.candidateDao = candidateDao;
    }

    @Autowired
    private CandidateMapper candidateMapper;

    public CandidateManager(CandidateMapper candidateMapper) {
        this.candidateMapper = candidateMapper;
    }


    @Override
    public SuccessDataResult<List<CandidateDto>> getAll() {
        return new SuccessDataResult<List<CandidateDto>>(candidateMapper.entityListToDtoList(candidateDao.findAll()));
    }
    @Override
    public SuccessDataResult<CandidateDto> getById(int id) {
        Candidate candidate=candidateDao.getById(id);
        CandidateDto candidateDto=candidateMapper.entityToDto(candidate);
        return new SuccessDataResult<CandidateDto>(candidateDto);
    }

    @Override
    public Result add(CandidateDto candidateDto){
        Candidate candidate=candidateMapper.dtoToEntity(candidateDto);
        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate added");
    }

    @Override
    public Result update(CandidateDto candidateDto){
        Candidate candidate=candidateMapper.dtoToEntity(candidateDto);
        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate updated");
    }

    @Override
    public Result delete(CandidateDto candidateDto){
        Candidate candidate=candidateMapper.dtoToEntity(candidateDto);
        this.candidateDao.delete(candidate);
        return new SuccessResult("Candidate deleted");

    }
/*
    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll(), "List of Candidates");

    }*/
/*
   @Override
   public DataResult<List<Candidate>> getAll(){
       List<CandidateDto> candidateDtoList = candidateDao.findAll()
               .stream()
               .map(this::convertEntityToDto)
               .collect(Collectors.toList());
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll(),"List of Candidates");
    }
*/


/*    private CandidateDto convertEntityToDto(Candidate candidate) {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setFirstName(candidate.getFirstName());
        candidateDto.setLastName(candidate.getLastName());
        candidateDto.setCandidateEmail(candidate.getCandidateEmail());
        candidateDto.setBirthDate(candidate.getBirthDate());
        candidateDto.setNationalityNo(candidate.getNationalityNo());
        return candidateDto;
    }*/


/*
    @Override
    public Result add(CandidateDto candidateDto) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setId(candidateDto.getId());
        candidate.setNationalityNo(candidateDto.getNationalityNo());

        this.candidateDao.save(candidate);
        return new SuccessResult("candidate added");
    }
*/


/*
    @Override
    public Result update(CandidateDto candidateDto) {
        Candidate candidate = this.candidateDao.getById(candidateDto.getId());
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setId(candidateDto.getId());
        candidate.setNationalityNo(candidateDto.getNationalityNo());
        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate updated");

    }
*/

/*    @Override
    public Result delete(CandidateDto candidateDto) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDto.getFirstName());
        candidate.setLastName(candidateDto.getLastName());
        candidate.setId(candidateDto.getId());
        candidate.setNationalityNo(candidateDto.getNationalityNo());

        this.candidateDao.delete(candidate);
        return new SuccessResult("Candidate deleted");

    }*/



    /*@Override
    public DataResult<Candidate> getCandidateByUserId(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findCandidateById(id));
    }*/




    /*@Override
    public SuccessDataResult<CandidateDto> findByCandidateEmail(String candidateEmail) {
        return new SuccessDataResult<CandidateDto>(this.candidateDao.findByCandidateEmail(candidateEmail));

    }*/
/*
    @Override
    public SuccessDataResult<CandidateDto> findByCandidateEmail(String candidateEmail) {
        Candidate candidate = candidateDao.findByCandidateEmail(candidateEmail);

        CandidateDto candidateDto = convertEntityToDto(candidate);


        return new SuccessDataResult<CandidateDto>(
                (candidateDto), "List of Candidates");
    }


    @Override
    public SuccessDataResult<CandidateDto> findByNationalityNo(String nationalityNo) {
        Candidate candidate = candidateDao.findByNationalityNo(nationalityNo);
        CandidateDto candidateDto = convertEntityToDto(candidate);
        return new SuccessDataResult<CandidateDto>(candidateDto);
    }
*/

    @Override
    public DataResult<List<Candidate>> getByFirstNameContains(String firstName) {

        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAllByFirstNameIgnoreCaseContains(firstName), "Data listelendi");

    }

    @Override
    public DataResult<List<Candidate>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll(sort));
    }


    @Override
    public DataResult<List<Candidate>> getByNameAndResume(String firstName, String lastName, int resumeId) {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.getByNameAndResume(firstName, lastName, resumeId));
    }


    private Result isCandidateEmailExist(String candidateEmail) {
       /* if (this.candidateDao.findByCandidateEmail(candidateEmail) != null) {
            return new ErrorResult("Email is exists");
        } else return new SuccessResult();*/
        return new SuccessResult();

    }

    private Result isNationalityNoExist(String nationalityNo) {
        if (this.candidateDao.findByNationalityNo(nationalityNo) != null) {
            return new ErrorResult("National number is exists");
        } else return new SuccessResult();
    }

}


