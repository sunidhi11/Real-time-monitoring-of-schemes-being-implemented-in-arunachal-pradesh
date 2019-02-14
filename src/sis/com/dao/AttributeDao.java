package sis.com.dao;

import java.util.ArrayList;

import java.util.HashMap;

import sis.com.bo.Attributes;

public interface AttributeDao {
	 boolean addAttributesTOForm(Attributes attributes);
	 HashMap<String,ArrayList<String>> getFormDb(String schemeCode);
      boolean createFormDb(ArrayList<String>columnName,ArrayList<String>columnType,String tablename);
}
