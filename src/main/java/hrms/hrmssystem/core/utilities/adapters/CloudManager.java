package hrms.hrmssystem.core.utilities.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.hrmssystem.core.utilities.results.DataResult;
import hrms.hrmssystem.core.utilities.results.ErrorDataResult;
import hrms.hrmssystem.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudManager implements CloudService {
    private final Cloudinary cloudinary;

    public CloudManager() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","dwmknfohn" );
        valuesMap.put("api_key", "946399146448414" );
        valuesMap.put("api_secret","cMOx83BTNbiSY3oFPw_GeEvUgX8" );
        cloudinary = new Cloudinary(valuesMap);
    }



    @Override
    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yuklenemedi");
        }
    }

    @Override
    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
