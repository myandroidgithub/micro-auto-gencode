package cn.javass.xgen.genconf.vo;

import java.util.HashMap;
import java.util.Map;

public class ThemeModel {

	public String id;
	public String location;
	
	private Map<String, GenTypeModel> mapGenType = new HashMap<String, GenTypeModel>();
	
	private Map<String, String> mapGenOutTypes = new HashMap<String, String>();
	
	private Map<String, String> mapproviders = new HashMap<String, String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, GenTypeModel> getMapGenType() {
		return mapGenType;
	}

	public void setMapGenType(Map<String, GenTypeModel> mapGenType) {
		this.mapGenType = mapGenType;
	}

	public Map<String, String> getMapGenOutTypes() {
		return mapGenOutTypes;
	}

	public void setMapGenOutTypes(Map<String, String> mapGenOutTypes) {
		this.mapGenOutTypes = mapGenOutTypes;
	}

	public Map<String, String> getMapproviders() {
		return mapproviders;
	}

	public void setMapproviders(Map<String, String> mapproviders) {
		this.mapproviders = mapproviders;
	}
	
	
}
