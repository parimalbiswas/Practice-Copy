package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer usersessionId;
	
	private Integer useroradminid;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
	private String konhai;
	
	private Integer cartId;

	public CurrentUserSession(Integer useroradminid, String uuid, LocalDateTime localDateTime, String konhai,
			Integer cartId) {
		super();
		this.useroradminid = useroradminid;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
		this.konhai = konhai;
		this.cartId = cartId;
	}
	
	
	
}
