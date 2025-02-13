package com.ui.pojo;

import java.util.Map;

public class Config {

	private Map<String,Environment> environments;
	
	public void setEnvironments(Map<String,Environment> environmnets)
	{
		this.environments=environmnets;
	}
	
	public Map<String,Environment> getEnvironments()
	{
		return environments;
	}
}
