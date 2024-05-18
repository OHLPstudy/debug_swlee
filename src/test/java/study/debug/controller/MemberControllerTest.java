package study.debug.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MemberControllerTest {
	MemberController memberController=new MemberController();



	@Test
	public void memberProcess(){
		doPost(Map.of("name", "이석운", "gender", "male"));
		doPost(Map.of("name","박대신","gender","male"));
		List<Map<String, Object>> maps = doGet();
	}
	void doPost(Map<String,Object> param) {
		String resultMessage = memberController.doPost(param);
	}
	private List<Map<String,Object>> doGet() {

		List<Map<String, Object>> maps = memberController.doGet();
		System.out.println("maps.toString() = " + maps.toString());
		return maps;
	}
	@Test
	public void 조건식브레이크(){
		List<Integer> list = initList();
		for (Integer item:list) {
			System.out.println("item = " + item);

		}
		System.out.println("테스트종료");
	}
~
	private  List<Integer> initList() {
		List<Integer>list = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			list.add(i);
		}
		return list;
	}∂∂

}