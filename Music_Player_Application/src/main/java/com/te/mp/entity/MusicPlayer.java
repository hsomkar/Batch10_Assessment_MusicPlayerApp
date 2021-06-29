package com.te.mp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MusicPlayer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10, nullable = false, unique = true)
	private Integer Song_ID;
	@Column(length = 50)
	private String Song_Title;
	@Column(length = 50)
	private String Artist_Name;
	@Column(length = 50)
	private String Album_Name;
	@Column(length = 50)
	private String Song_Location;
	@Column(length = 250)
	private String Description;
}
