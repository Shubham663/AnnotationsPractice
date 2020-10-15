package com.bridgelabz.annotationspractice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfo {
	String author() default "Shubham Mittal";

	String info();

	int noOfMethods() default 0;

	int noOfVariables() default 0;
}