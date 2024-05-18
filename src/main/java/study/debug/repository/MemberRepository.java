package study.debug.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
	private final List<Map<String,Object>> resultArray= new ArrayList();
	public List<Map<String,Object>>selectListMember(){
		return this.resultArray;
	}
	public boolean postMember(Map<String,Object>param){
		/*
		if(!userPostValidation(param)){
			throw new IllegalArgumentException();
		}
		*/
		resultArray.add(param);
		return true;
	}

	private static boolean userPostValidation(Map<String, Object> param) {
		return param.get("name") != null && param.get("gender") != null;
	}

}
