package com.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Role {

	@Id
	private Long roleId;
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY,mappedBy = "role" )
	private Set<UserRole> userRoles = new HashSet<>();
}
