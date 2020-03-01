package com.kmboot.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "seq_user", initialValue = 1, allocationSize = 1)

public class KMUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	private Long id;

	private String name;

	private String email;

	private String mobile;

	private String password;
}
