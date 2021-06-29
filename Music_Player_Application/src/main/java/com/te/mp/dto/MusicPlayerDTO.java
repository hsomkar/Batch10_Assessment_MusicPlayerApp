package com.te.mp.dto;

import lombok.Data;

@Data
public class MusicPlayerDTO {
	private Integer Song_ID;
	private String Song_Title;
	private String Artist_Name;
	private String Album_Name;
	private String Song_Location;
	private String Description;
}
