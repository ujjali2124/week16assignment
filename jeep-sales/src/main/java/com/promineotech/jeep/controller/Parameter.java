/**
 * 
 */
package com.promineotech.jeep.controller;

/**
 * @author UJJVAL
 *
 */
public @interface Parameter {

  String name();

  boolean allowEmptyValue();

  boolean required();

  String description();

}
