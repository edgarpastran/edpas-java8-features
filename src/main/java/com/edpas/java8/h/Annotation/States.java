package com.edpas.java8.h.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface States {

	State[] value() default {};
	
}
