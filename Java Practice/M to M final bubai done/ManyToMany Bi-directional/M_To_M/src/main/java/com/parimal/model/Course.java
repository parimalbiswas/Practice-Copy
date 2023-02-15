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
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	private String cName;

	private Integer cFee;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.DETACH, mappedBy = "courses", fetch = FetchType.EAGER)
	private List<Student> students = new ArrayList<>();
}
