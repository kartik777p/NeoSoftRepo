package com.neosoft.besics;

public class Intern extends Devloper {
	int probation;
	String certification;

	public int getProbation() {
		return probation;
	}

	public void setProbation(int probation) {
		this.probation = probation;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	//showStatus
	public  void showStatus() {
		System.out.println("Probation is:- "+probation);
		System.out.println("Certification in :- "+certification);
		
	}
}
