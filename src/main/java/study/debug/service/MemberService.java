package study.debug.service;

import java.util.List;
import java.util.Map;

import study.debug.repository.MemberRepository;

public class MemberService {
	private final MemberRepository memberRepository=new MemberRepository();
	public List<Map<String,Object>> selectMemberList(){
		return memberRepository.selectListMember();
	}
	public String postMember(Map<String,Object>param){
		if(memberRepository.postMember(param)){
			return "Success";
		}else{
			return "Fail";
		}

	}
}
