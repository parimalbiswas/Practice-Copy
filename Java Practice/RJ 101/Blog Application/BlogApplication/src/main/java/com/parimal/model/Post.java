package com.parimal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postid;

	@Column(name = "post_title", length = 100, nullable = false)
	private String title;

	private String content;

	private LocalDate posttime;

	@ManyToOne
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> posts = new ArrayList<>();

}
