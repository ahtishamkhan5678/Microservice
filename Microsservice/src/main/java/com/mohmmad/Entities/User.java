package com.mohmmad.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_users")// we give the table name here
public class User {
	
	@Id
	@Column(name="ID")
	private String userId;
	
	@Column(name="Name", length=20)
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="About")
	private String about;
	
	
	
	@Transient // it is used to ignore for database; for now
	private List<Rating> ratings = new ArrayList<>();

	
	
}
