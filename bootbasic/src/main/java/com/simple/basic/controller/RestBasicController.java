package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple.basic.command.RestVO;
import com.sun.net.httpserver.Headers;

@RestController //컨트롤러 + @responsebody
public class RestBasicController {
	
	//consumer : 반드시 이 타입으로 데이터를 달라는 의미 (default 제이슨)
	//produces : 해당타입으로 응답하겠다는 의미 (default 제이슨)
	@GetMapping(value =  "/hello", produces = "text/plain" )
	public String hello() {
		System.out.println("실행됨");
		return "왜불러?";
	}
	
	//객체를 반환하는 모형
	//객체를 반환할때 produces는 디폴트 값으로 json형식을 가집니다.
	//jackson-data-bind모듈이 반드시 필요합니다( 스프링 부트에는 자동으로 포함)
	@GetMapping(value = "/getObject", produces = "application/json;charset=UTF-8")
	public RestVO getObject() {
		
		return new RestVO(1, "헬로", "테스트");
	}
	
	@GetMapping(value = "/getObject2", produces = "application/json;charset=UTF-8")
	public Map<String, Object> getObject2() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", new RestVO(1, "헬로", "테스트") );
		
		return map;
	}
	//리스트형식의 반환
	@GetMapping(value = "/getObject3", produces = "application/json;charset=UTF-8")
	public List<RestVO> getObject3() {
		
		List<RestVO> list = new ArrayList<>();
		list.add( new RestVO(1, "헬로", "테스트")  );
		list.add( new RestVO(1, "헬로2", "테스트2")  );

		return list;
	}
	
	///////////////////get방식으로 데이터를 받는방법////////////////////
	//로컬호스트:8181/getData?key=홍길동&bno=1
	//RequestParam는 값을 반드시 필수로 보내야 합니다. (required=true)
	@CrossOrigin("*")
	@GetMapping("/getData")
	public RestVO getData(@RequestParam("key") String key,
						  @RequestParam("bno") int bno ) {
		
		System.out.println(key);
		System.out.println(bno);
		
		return new RestVO(1, "헬로", "테스트");
	}
	
	//로컬호스트:8181/getData2/홍길동/1
	@GetMapping("/getData2/{name}/{bno}")
	public RestVO getData2(@PathVariable("name") String name,
						   @PathVariable("bno") int bno ) {
		
		System.out.println(name);
		System.out.println(bno);
		
		return new RestVO(1, "헬로", "테스트");
	}
	
	//////////////////post방식으로 값받기////////////
	//VO를 이용해서 받기
	//1. @RequestBody로 맵핑시킨다.
	//2. JSON데이터는 키와 값을 "" 형태로 반드시 묶어야 합니다
	//{"name": "홍길동", "num": 1, "id": "aaa"}
	@CrossOrigin("*") //서버가 다른경우 허용
	@PostMapping("/getJSON")
	public List<RestVO> getJSON(@RequestBody RestVO vo) {
		
		//num, name, id
		System.out.println(vo.toString());
		
		List<RestVO> list = new ArrayList<>();
		list.add(new RestVO(1, "홍길동", "3") );
		list.add(new RestVO(1, "이순신", "3") );
		
		return list;
	}
	
	//map을 이용해서 받기
	@PostMapping("/getMap")
	public RestVO getMap(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
		
		return null;
	}
	
	//Post에서 Consumers를 통한 데이터제한
	//consumers - 반드시 이 데이터 타입으로 보내라
	//화면에서는 Content-Type속성을 반드시 text/plain으로 맞추고 보내야합니다.
	@PostMapping(value="/getText", consumes = "text/plain")
	public RestVO getText(@RequestBody String data) {
		
		System.out.println(data);
		
		return null;
	}
	
	
	//커스텀 문서를 직접 보내는 방법
	@PostMapping("/createResponse")
	public ResponseEntity<RestVO> createResponse() {
		
		
		RestVO vo = new RestVO(1, "헬로", "test"); //데이터
		HttpHeaders header = new HttpHeaders(); //헤더
		header.add("Authorization", "json_web_token"); 
		
		ResponseEntity<RestVO> res = new ResponseEntity<>(vo, header, HttpStatus.OK); //데이터, 헤더정보, 상태정보
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
}
