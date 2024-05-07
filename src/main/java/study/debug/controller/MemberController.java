package study.debug.controller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import study.debug.service.MemberService;

public class MemberController {
	private final MemberService memberService= new MemberService();
	public List<Map<String,Object>> doGet(){
		List<Map<String, Object>> result = memberService.selectMemberList();
		return result;
	}
	public String doPost(Map<String,Object>param){
		return memberService.postMember(param);


	}
}
