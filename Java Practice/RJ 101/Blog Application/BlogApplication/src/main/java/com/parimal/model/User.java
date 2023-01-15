package com.parimal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	private String username;
	private String mobile;

	private String email;
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();

//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Comment> comments = new ArrayList<>();

}
