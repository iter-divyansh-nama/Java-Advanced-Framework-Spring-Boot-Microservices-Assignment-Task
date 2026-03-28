package com.capgemini.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentResponse {
	private Integer id;
	private String name;
	private String mailId;
	private Long contactNumber;
	private Project project;
}