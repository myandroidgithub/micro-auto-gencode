package cn.javass.xgen.genconf;

import java.util.Map;

import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

public interface GenConfEbi {

	/**
	 * 获取xgen核心框架运行所需要的配置数据model
	 * @return
	 */
	public GenConfModel getGenConf();
	
	/**
	 * 获取需要生成的所有模块的配置
	 * @return
	 */
	public Map<String, ModuleConfModel> getMapModuleConf();
	
}
