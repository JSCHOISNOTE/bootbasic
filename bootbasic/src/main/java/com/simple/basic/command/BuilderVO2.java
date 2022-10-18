package com.simple.basic.command;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data //getter, setter, toString
@Builder
public class BuilderVO2 {

	private String name;
	private int age;
}
