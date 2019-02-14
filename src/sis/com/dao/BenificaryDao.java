package sis.com.dao;

import java.util.List;

import sis.com.bo.Benificary;


public interface BenificaryDao {
	boolean addRegisteredBenificiary(Benificary benificary);
	 List<Benificary> ShowAllBenificiary();
	 Benificary ShowBenificiaryById(int applicantId);
	
}
