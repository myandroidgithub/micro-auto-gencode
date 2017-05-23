package cn.javass.xgen.genconf.implementor;

import java.util.List;
import java.util.Map;

import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

public interface ModuleGenConfImplementor {

	public ModuleConfModel getBaseModuleConfModel(Map<String, String> param);
	
	public Map<String, List<String>> getMapNeedGenTypes(Map<String, String> param);
	
	public Map<String, ExtendConfModel> getMapExtends(GenConfModel gm,Map<String, String> param);
}
