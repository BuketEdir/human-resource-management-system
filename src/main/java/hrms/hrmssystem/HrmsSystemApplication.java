package hrms.hrmssystem;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudinary.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;

@SpringBootApplication
public class HrmsSystemApplication {




	public static void main(String[] args) {
		SpringApplication.run(HrmsSystemApplication.class, args);/*
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dwmknfohn",
				"api_key", "946399146448414",
				"api_secret", "cMOx83BTNbiSY3oFPw_GeEvUgX8",
				"secure", true));

		File file = new File("my_image.jpg");


	}


		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		System.out.println(uploadResult.get("url"));*/
	}



}
