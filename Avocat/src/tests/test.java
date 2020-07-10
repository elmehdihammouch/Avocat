package tests;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.daoAjouterDossier;
import DAO.daoAjouterDossier.MyResult;

public class test {

	
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<MyResult> res = new ArrayList<>();
		res = daoAjouterDossier.listDossier();
		String json = mapper.writeValueAsString(res);
		System.out.println(json);
	}

}
