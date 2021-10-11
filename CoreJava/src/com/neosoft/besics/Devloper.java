package com.neosoft.besics;

public class Devloper  extends Employee{

			String skills;
			public String getSkills() {
				return skills;
			}

			public void setSkills(String skills) {
				this.skills = skills;
			}

			public String getProjectName() {
				return projectName;
			}

			public void setProjectName(String projectName) {
				this.projectName = projectName;
			}

			String projectName;
			
			//method
			public void showProfile() {
				System.out.println("Skills are :- "+skills);
				System.out.println("Project Name is:- "+projectName);
			
		}
}
