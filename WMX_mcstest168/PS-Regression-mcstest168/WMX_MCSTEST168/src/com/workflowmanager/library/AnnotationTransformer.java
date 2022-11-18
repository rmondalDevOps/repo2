package com.workflowmanager.library;

/*****
 * 
 * Class: AnnotationTransformer 
 * This class implements IAnnotationTransformer and it lets 
 * control the @test annotation at runtime.
 * 
 * it overrides the transformer method which checks the excel and 
 * based on Y/N values in Runmode, sets 'enabled' to true or false
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.workflowmanager.library.TestBase;

/**
 * 
 * 
 *
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		try {
			TestBase.excelSetup();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		boolean enabled= CommonFunction.isTestExecutable(testMethod.getName());
		System.out.println(testMethod.getName() + "----" + enabled);
		annotation.setEnabled(enabled);
	}
}

