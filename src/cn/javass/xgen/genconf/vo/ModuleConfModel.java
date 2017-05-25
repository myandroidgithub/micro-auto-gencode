package cn.javass.xgen.genconf.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <?xml version="1.0" encoding="UTF-8"?>
   <ModuleGenConf id=“UserConf”>
		<NeedGenTypes>
			<NeedGenType id="GenBusinessEbi">
				<NeedGenOutType id="File"></NeedGenOutType>
			</NeedGenType>
		</NeedGenTypes>
		<ExtendConfs>
			<ExtendConf id="moduleName" isSingle="true">user</ExtendConf>
		</ExtendConfs>
	</ModuleGenConf>
 *
 */
public class ModuleConfModel {

	private String moduleId = "";
	
	private String useTheme = "";
	
	/////
	private Map<String, List<String>> mapNeedGenTypes = new HashMap<String, List<String>>();
	
	private Map<String, ExtendConfModel> mapExtends = new HashMap<String, ExtendConfModel>();

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getUseTheme() {
		return useTheme;
	}

	public void setUseTheme(String useTheme) {
		this.useTheme = useTheme;
	}

	public Map<String, List<String>> getMapNeedGenTypes() {
		return mapNeedGenTypes;
	}

	public void setMapNeedGenTypes(Map<String, List<String>> mapNeedGenTypes) {
		this.mapNeedGenTypes = mapNeedGenTypes;
	}

	public Map<String, ExtendConfModel> getMapExtends() {
		return mapExtends;
	}

	public void setMapExtends(Map<String, ExtendConfModel> mapExtends) {
		this.mapExtends = mapExtends;
	}
	
	
	
}
