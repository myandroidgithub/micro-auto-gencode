package cn.javass.xgen.genconf;

import java.util.Map;

import cn.javass.xgen.genconf.confmanager.Confmanager;
import cn.javass.xgen.genconf.implementor.GenConfImplementor;
import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

public class GenConfEbo implements GenConfEbi{

	private static GenConfEbo ebo = null;
	
	/**
	 * 持有 获取核心框架配置数据的 具体实现接口对象
	 */
	private GenConfImplementor provider = null;
	
	private GenConfEbo(GenConfImplementor provider) {
		this.provider = provider;
	}
	
	public static GenConfEbi getInstance(GenConfImplementor provider){
		if (ebo == null) {
			ebo = new GenConfEbo(provider);
		}
		return ebo;
	}
	
	@Override
	public GenConfModel getGenConf() {
		
		return Confmanager.getInstance(provider).getGenConf();
	}

	@Override
	public Map<String, ModuleConfModel> getMapModuleConf() {
		return Confmanager.getInstance(provider).getMapModuleConf();
	}
}
