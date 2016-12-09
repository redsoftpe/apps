package com.redhat.web;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ChangeMoney {
     @WebMethod
	 public double changeDolar(double value);
	
}
