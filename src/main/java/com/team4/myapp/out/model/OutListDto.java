package com.team4.myapp.out.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OutListDto {
	private List<OutDto> outlist;
	private long total;
	private int hours;
	private int minutes;
	private int seconds;
}
