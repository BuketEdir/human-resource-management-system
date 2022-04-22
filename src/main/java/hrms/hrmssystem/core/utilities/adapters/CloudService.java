package hrms.hrmssystem.core.utilities.adapters;

import hrms.hrmssystem.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudService {
    DataResult<Map<String, String>> upload(MultipartFile multipartFile);



    DataResult<Map> delete(String id) throws IOException;



}
