package hrms.hrmssystem.bussiness.concretes;

import hrms.hrmssystem.bussiness.abstracts.CandidateService;
import hrms.hrmssystem.bussiness.abstracts.ImageService;
import hrms.hrmssystem.core.utilities.adapters.CloudService;
import hrms.hrmssystem.core.utilities.results.*;
import hrms.hrmssystem.dataAccess.abstracts.ImageDao;
import hrms.hrmssystem.entities.concretes.City;
import hrms.hrmssystem.entities.concretes.Image;
import hrms.hrmssystem.entities.dtos.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    private CloudService cloudService;
    private CandidateService candidateService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudService cloudService, CandidateService candidateService) {
        super();
        this.imageDao = imageDao;
        this.cloudService = cloudService;
        this.candidateService = candidateService;
    }
/*

    @Override
    public Result add(MultipartFile multipartFile, int candidateId) {
        var result=this.cloudService.upload(multipartFile);
        if(!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        var candidate = this.candidateService.getById(candidateId).getData();
        Image image = new Image();
        image.setCandidate(candidate);
        image.setImageUrl(result.getData().get("url"));
        image.setPublicId(result.getData().get("public_id"));
        this.imageDao.save(image);
        return new SuccessResult("Fotograf eklendi");
    }
*/

    @Override
    public DataResult<Image> getById(int candidateId) {
        return new SuccessDataResult<Image>(this.imageDao.getByCandidateId(candidateId));
    }




    @Override
    public Result delete(int id) throws IOException {
        var publicId = this.imageDao.findById(id).get().getPublicId();
        var result = this.cloudService.delete(publicId);
        this.imageDao.deleteById(id);
        return new SuccessResult("Fotograf silindi");
    }


}
