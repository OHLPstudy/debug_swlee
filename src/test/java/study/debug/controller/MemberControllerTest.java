package study.debug.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MemberControllerTest {
	MemberController memberController=new MemberController();
	List<Map<String,Object>> doGet() {
		List<Map<String, Object>> maps = memberController.doGet();
		System.out.println("maps.toString() = " + maps.toString());
		return maps;
	}

	void doPost(Map<String,Object> param) {
		String resultMessage = memberController.doPost(param);
	}
	@Test
	public void memberProcess(){
		doPost(Map.of("name", "이석운", "gender", "male"));
		doPost(Map.of("name","박대신","gender","male"));
		List<Map<String, Object>> maps = doGet();
	}
}