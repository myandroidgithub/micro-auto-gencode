package cn.javass.xgen.genconf.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenConfModel {

	private List<NeedGenModel> needGens = new ArrayList<NeedGenModel>();
	
	private List<ThemeModel> themes = new ArrayList<ThemeModel>();
	
	private Map<String, String> mapConstants = new HashMap<String, String>();

	
	public List<NeedGenModel> getNeedGens() {
		return needGens;
	}

	public void setNeedGens(List<NeedGenModel> needGens) {
		this.needGens = needGens;
	}

	public List<ThemeModel> getThemes() {
		return themes;
	}

	public void setThemes(List<ThemeModel> themes) {
		this.themes = themes;
	}

	public Map<String, String> getMapConstants() {
		return mapConstants;
	}

	public void setMapConstants(Map<String, String> mapConstants) {
		this.mapConstants = mapConstants;
	}
	
	public ThemeModel getThemeById(String themeId){
		for(ThemeModel tm : this.themes ){
			if(tm.getId().equals(themeId)){
				return tm;
			}
		}
		return new ThemeModel();
	}
	
}
