package cn.javass.xgen.genconf.implementor;

import java.util.List;
import java.util.Map;

import cn.javass.xgen.genconf.vo.NeedGenModel;
import cn.javass.xgen.genconf.vo.ThemeModel;

/**
 * 获取核心框架配置数据的接口
 */
public interface GenConfImplementor {

	public List<NeedGenModel> getNeedGens();
	
	public List<ThemeModel> getThemes();
	
	public Map<String, String> getMapConstants();
}
