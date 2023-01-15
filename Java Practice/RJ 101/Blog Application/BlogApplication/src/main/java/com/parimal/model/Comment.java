package com.parimal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentid;
	private String commentDescription;

	private Integer userId;

	private LocalDateTime commenttime;

}
