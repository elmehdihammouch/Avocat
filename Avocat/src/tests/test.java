package tests;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import DAO.daoAjouterProces;
import DAO.daoAjouterProces.notif;

public class test {

	
	
	public static void main(String[] args) throws JsonProcessingException {
		String he = "je n'aime pas le chocolat";
		System.out.println(he.replace("'", "\\'"));
	}

}
