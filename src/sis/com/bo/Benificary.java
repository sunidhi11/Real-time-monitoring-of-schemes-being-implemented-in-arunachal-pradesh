package sis.com.bo;

import java.io.InputStream;
import java.sql.Date;



public class Benificary {
	
	private String applicationId;

	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	private String  District; 
	private String panchayat;
	private String block;
	private String name;
	 private Date dob;
	 private String Husband;
	 private String Address;
	 private String Email;
	 private String mobile;
	 private String Hospital;
	 private String gender;
	 private String adhharNo;
	 private String maritial;
	 private String selected;
	 private String schemeCode;
	 private InputStream adhharProof;
		private String adhharProofName;
		private int adhharProofSize;
		 private InputStream residentProof;
			private String residentProofName;
			private int residentProofSize;
	 
	 
	public InputStream getAdhharProof() {
				return adhharProof;
			}
			public void setAdhharProof(InputStream adhharProof) {
				this.adhharProof = adhharProof;
			}
			public String getAdhharProofName() {
				return adhharProofName;
			}
			public void setAdhharProofName(String adhharProofName) {
				this.adhharProofName = adhharProofName;
			}
			public int getAdhharProofSize() {
				return adhharProofSize;
			}
			public void setAdhharProofSize(int adhharProofSize) {
				this.adhharProofSize = adhharProofSize;
			}
			public InputStream getResidentProof() {
				return residentProof;
			}
			public void setResidentProof(InputStream residentProof) {
				this.residentProof = residentProof;
			}
			public String getResidentProofName() {
				return residentProofName;
			}
			public void setResidentProofName(String residentProofName) {
				this.residentProofName = residentProofName;
			}
			public int getResidentProofSize() {
				return residentProofSize;
			}
			public void setResidentProofSize(int residentProofSize) {
				this.residentProofSize = residentProofSize;
			}
	public String getBlock() {
			return block;
		}
		public void setBlock(String block) {
			this.block = block;
		}
	 public String getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getPanchayat() {
		return panchayat;
	}
	public void setPanchayat(String panchayat) {
		this.panchayat = panchayat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getHusband() {
		return Husband;
	}
	public void setHusband(String husband) {
		Husband = husband;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHospital() {
		return Hospital;
	}
	public void setHospital(String hospital) {
		Hospital = hospital;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdhharNo() {
		return adhharNo;
	}
	public void setAdhharNo(String adhharNo) {
		this.adhharNo = adhharNo;
	}
	public String getMaritial() {
		return maritial;
	}
	public void setMaritial(String maritial) {
		this.maritial = maritial;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	

}
