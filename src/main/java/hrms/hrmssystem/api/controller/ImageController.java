package hrms.hrmssystem.api.controller;

import hrms.hrmssystem.bussiness.abstracts.ImageService;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.Result;
import hrms.hrmssystem.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        super();
        this.imageService = imageService;
    }
/*

    @PostMapping("/add")
    public Result add(@RequestPart MultipartFile image, int id) {
        return this.imageService.add(image, id);
    }
*/

    @GetMapping("/getById")
    public DataResult<Image> getById(int id){
        return this.imageService.getById(id);
    }

    @GetMapping("/delete")
    public Result delete(int id) throws IOException {
        return this.imageService.delete(id);
    }
}
