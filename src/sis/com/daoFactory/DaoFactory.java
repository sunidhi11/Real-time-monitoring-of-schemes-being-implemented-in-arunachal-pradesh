package sis.com.daoFactory;

import sis.com.dao.AdminAddScheme;
import sis.com.dao.AttributeDao;
import sis.com.dao.BenificaryDao;
import sis.com.dao.DynamicFormDao;
import sis.com.dao.query;
import sis.com.dao.impl.AdminAddSchemeImp;
import sis.com.dao.impl.AttributeDaoImpl;
import sis.com.dao.impl.BenificaryDaoImpl;
import sis.com.dao.impl.DynamicFormDaoImpl;
import sis.com.dao.impl.queryImpl;


public class DaoFactory {
	private static BenificaryDao	benificaryDao;
	public static BenificaryDao getBenificaryDao(){
	
		if(benificaryDao==null){
			benificaryDao = new BenificaryDaoImpl();
		}
		return benificaryDao;
}
	
	private static AttributeDao attributeDao;
	public static AttributeDao getAttributeDao(){
		if(attributeDao == null){
			attributeDao = new AttributeDaoImpl();
		}
		return attributeDao;
	}
	private static DynamicFormDao dynamicformDao;
	public static DynamicFormDao geDynamicFormDao(){
		if(dynamicformDao == null){
			dynamicformDao = new DynamicFormDaoImpl();
		}
		return dynamicformDao;
	}
	
static AdminAddScheme adminAddScheme = null;
	
	public static AdminAddScheme getAdminAddScheme() {
		if(adminAddScheme!=null){
			return adminAddScheme;
		}
		else{
			return new AdminAddSchemeImp();
		}
		
	}
	private static query qdao;
	public static query getQueryDao(){
		if(qdao==null){
			qdao=new queryImpl();
		}
		return qdao;
	}
}
