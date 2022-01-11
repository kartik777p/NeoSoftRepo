package com.neosoft.springboot.bean;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "customer")
public class CustomerBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String password;
	@Column(unique = true)
	private String email;
	private long mobile;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "customers_roles",
			joinColumns = @JoinColumn(
		            name = "customer_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;

	public CustomerBean(String name, String password, String email, long mobile, Collection<Role> roles) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.roles = roles;
	}
}
