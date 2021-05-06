package com.qa.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.qa.enums.CategoryType;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.<p>
 * 
 * Method Target value indicate that this annotation will be applicable for @test methods
 * 
 * @author rajasekhar
 *	
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

	/**
	 * @author rajasekhar
	 * @return Store the authors who created the tests in String[] <p>
	 * Mandatory to enter atleast a value
	 */
	public String[] author();
	
	/**
	 * @author rajasekhar
	 * @return  Stores the category in form of Enum Array. <p>
	 * Include the possible values in {@link com.qa.enums.CategoryType}
	 */
	public CategoryType[] category();
}
