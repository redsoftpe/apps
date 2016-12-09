package com.redhat.web;

import javax.jws.WebService;


@WebService(endpointInterface="com.redhat.web.ChangeMoney",
		     serviceName = "ChangeMoneyWS"
		     )
public class ChangeMoneyWS implements ChangeMoney {

	private double CHANGE_VALUE=661; //pesos por dolar
	
	@Override
	public double changeDolar(double value) {
		// TODO Auto-generated method stub
		double result = value/CHANGE_VALUE;
		return result;
	}

}
