package cn.javass.xgen.genconf.implementor.xmlimpl;

import java.util.List;
import java.util.Map;

import cn.javass.xgen.genconf.implementor.ModuleGenConfImplementor;
import cn.javass.xgen.genconf.vo.ExtendConfModel;
import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

public class ModuleGenConfXmlImpl implements ModuleGenConfImplementor {

	@Override
	public ModuleConfModel getBaseModuleConfModel(Map<String, String> param) {
		return null;
	}

	@Override
	public Map<String, List<String>> getMapNeedGenTypes(Map<String, String> param) {
		return null;
	}

	@Override
	public Map<String, ExtendConfModel> getMapExtends(GenConfModel gm, Map<String, String> param) {
		return null;
	}
}
