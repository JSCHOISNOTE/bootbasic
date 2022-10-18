package com.simple.basic.command;

public class BuilderVO {
	//private, public, protected, default
	//static - 1개생성( 객체마다 변수 공유, 클래스명.static변수) 
	
	//1. 멤버변수
	private String name;
	private int age;
	
	//6.BuilderVO의 생성(생성될때 내부클래스가 가지고 있는 name,age값을 받음)
	private BuilderVO(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
	}
	
	//7. static키워드를 이용해서 외부에서 객체생성을 요구할때 builder메서드를 호출
	public static Builder builder() {
		return new Builder();
	}
	
	//8 toString override(alt shift s)
	@Override
	public String toString() {
		return "Builder [name=" + name + ", age=" + age + "]";
	}
	
	//2. 내부클래스
	public static class Builder {
		

		//3. 변수와 생성자
		private String name;
		private int age;
		
		//4. 생성자 제한
		private Builder() {}
		//5. setter메서드만 생성하고, 나자신을 반환시킨다(this)
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		//8. build메서드를 실행해서 6번의 생성자를 통해 값을 저장
		public BuilderVO build() {
			return new BuilderVO(this);
		}
		
		
		
		
	}
}
