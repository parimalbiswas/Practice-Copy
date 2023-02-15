package com.parimal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;

	private String sName;

	private String sPassword;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<Course> courses = new ArrayList<>(); //

}
