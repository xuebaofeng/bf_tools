package com.xue.test;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class ReflectionTest {

	public void getUser(String userId){

	}

	public static void main(String[] args){
		Method[] methods = ReflectionTest.class.getDeclaredMethods();
		for(Method method: methods){
			TypeVariable<Method>[] typeParameters = method.getTypeParameters();
			for(TypeVariable<Method> typeParameter: typeParameters){
				String name = typeParameter.getName();
				System.out.println(name);
			}
		}
	}
}
