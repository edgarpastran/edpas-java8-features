package com.edpas.java8.h.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(value = States.class)
public @interface State {

	String value();
	
}
