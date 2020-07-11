package tests;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import DAO.daoAjouterProces;
import DAO.daoAjouterProces.notif;

public class test {

	
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<notif> res = new ArrayList<>();
		res = daoAjouterProces.listdenotif();
		String json = mapper.writeValueAsString(res);
		System.out.println(json);
	}

}
