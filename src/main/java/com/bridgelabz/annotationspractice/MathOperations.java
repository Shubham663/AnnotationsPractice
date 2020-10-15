package com.bridgelabz.annotationspractice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.processing.SupportedAnnotationTypes;

@ClassInfo(info = "Used for performing various math operations", noOfMethods = 2, noOfVariables = 2)
public class MathOperations {
	int x;
	int y;

	@MethodInfo(date = "15 Oct,2020")
	@Deprecated
	public int sum() {
		return x + y;
	}

	@MethodInfo(date = "16 Oct,2020")
	public int subtract() {
		return x - y;
	}

	@Override
	@MethodInfo(date = "17 Oct,2020")
	public String toString() {
		return ("x:" + x + " y:" + y + "\n");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to annotations demo");
		Class clas = MathOperations.class;
		System.out.println("The various annotations present on this class are: ");
		Annotation[] annotations = clas.getAnnotations();
		System.out.println(annotations.length);
		for (Annotation annotation : clas.getAnnotations()) {
			System.out.println(annotation.annotationType());
		}
		for (Method method : MathOperations.class.getDeclaredMethods()) {
			if (method.isAnnotationPresent(MethodInfo.class)) {
				for (Annotation annotation : method.getAnnotations()) {
					System.out.println("Annotation in method :" + method.getName() + " :" + annotation);
				}
				MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
				if (methodInfo.revision() == 1) {
					System.out.println("The method with revision 1 :" + method.getName());
				}
			}
		}
	}
}
