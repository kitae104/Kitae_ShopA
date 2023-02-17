package kr.inhatc.spring.test.entity;

import jakarta.persistence.*;

@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 20)
	private String myName;
	private int myAge;
	
	private String myInfo;
}
