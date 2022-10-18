package com.simple.basic.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;


@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Value("${project.upload.path}")
	private String uploadPath;
	
	//폴더생성함수
	public String makeFolder() {
		
		String path = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMM") );
		File file = new File(uploadPath + "\\" + path);
		if( file.exists() == false ) {
			file.mkdirs(); //파일생성
		}
		return path; //경로
	}
	//upload화면
	@GetMapping("/upload")
	public void upload() {
		
	}

	//일반업로드
	@PostMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file) {
		//실제파일명 (브라우저별로 조금씩 다를수가있음)
		String origin = file.getOriginalFilename();
		//저장할파일명(경로가 \\가 들어오는 경우 잘라서 처리)
		String filename = origin.substring(origin.lastIndexOf("\\") + 1);
		//파일사이즈
		long size = file.getSize();
		//랜덤이름
		String uuid = UUID.randomUUID().toString();
		//날짜경로
		String path = makeFolder();
		//업로드경로
		String saveName = uploadPath + "\\"+ path  +"\\"+ uuid + "_" + filename;
		
		System.out.println(filename);
		System.out.println(size);
		System.out.println(saveName);
		
		try {
			File saveFile = new File(saveName); 
			file.transferTo(saveFile); //파일업로드
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업로드중 에러 발생");
		}
		return "upload/upload_ok"; 
	}
	
	//multiple옵션
	@PostMapping("/upload_ok2")
	public String upload_ok2(MultipartRequest files) {
		//화면에서 넘어오는 name속성
		List<MultipartFile> list = files.getFiles("file"); 
		
		for(MultipartFile file: list) {
			//실제파일명 (브라우저별로 조금씩 다를수가있음)
			String origin = file.getOriginalFilename();
			//저장할파일명(경로가 \\가 들어오는 경우 잘라서 처리)
			String filename = origin.substring(origin.lastIndexOf("\\") + 1);
			//파일사이즈
			long size = file.getSize();
			//랜덤이름
			String uuid = UUID.randomUUID().toString();
			//날짜경로
			String path = makeFolder();
			//업로드경로
			String saveName = uploadPath + "\\"+ path  +"\\"+ uuid + "_" + filename;
			
			System.out.println(filename);
			System.out.println(size);
			System.out.println(saveName);
			
			try {
				File saveFile = new File(saveName); 
				file.transferTo(saveFile); //파일업로드
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("업로드중 에러 발생");
			}
			
		}
		
		return "upload/upload_ok"; 
	}
	
	
	//복수태그를 이용한 여러태그
	@PostMapping("/upload_ok3")
	public String upload_ok3(@RequestParam("file") List<MultipartFile> list) {
		
		//list에서 빈파일은 제거
		list = list.stream().filter( (f) -> !f.isEmpty()  ).collect( Collectors.toList() );
		
		for(MultipartFile file: list) {
			//실제파일명 (브라우저별로 조금씩 다를수가있음)
			String origin = file.getOriginalFilename();
			//저장할파일명(경로가 \\가 들어오는 경우 잘라서 처리)
			String filename = origin.substring(origin.lastIndexOf("\\") + 1);
			//파일사이즈
			long size = file.getSize();
			//랜덤이름
			String uuid = UUID.randomUUID().toString();
			//날짜경로
			String path = makeFolder();
			//업로드경로
			String saveName = uploadPath + "\\"+ path  +"\\"+ uuid + "_" + filename;
			
			System.out.println(filename);
			System.out.println(size);
			System.out.println(saveName);
			
			try {
				File saveFile = new File(saveName); 
				file.transferTo(saveFile); //파일업로드
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("업로드중 에러 발생");
			}
			
		}
		
		return "upload/upload_ok";
	}
	
	
	//비동기업로드
	//화면에서 넘어오는 데이터는 Form형식이라서 @RequestBody는 없어도 됩니다.
	@ResponseBody //요청이 온곳으로 값을 반환함
	@PostMapping("/upload_ok4")
	public String upload_ok4(/*vo*/ @RequestParam("writer") String writer,
									@RequestParam("file") MultipartFile file ) {
		
		System.out.println(writer);
		
		//실제파일명 (브라우저별로 조금씩 다를수가있음)
		String origin = file.getOriginalFilename();
		//저장할파일명(경로가 \\가 들어오는 경우 잘라서 처리)
		String filename = origin.substring(origin.lastIndexOf("\\") + 1);
		//파일사이즈
		long size = file.getSize();
		//랜덤이름
		String uuid = UUID.randomUUID().toString();
		//날짜경로
		String path = makeFolder();
		//업로드경로
		String saveName = uploadPath + "\\"+ path  +"\\"+ uuid + "_" + filename;
		
		System.out.println(filename);
		System.out.println(size);
		System.out.println(saveName);
		
		try {
			File saveFile = new File(saveName); 
			file.transferTo(saveFile); //파일업로드
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업로드중 에러 발생");
		}
		
		
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
}
