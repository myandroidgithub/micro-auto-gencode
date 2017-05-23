package cn.javass.xgen.genconf.confmanager;

import java.util.HashMap;
import java.util.Map;

import cn.javass.xgen.genconf.implementor.GenConfImplementor;
import cn.javass.xgen.genconf.implementor.ModuleGenConfImplementor;
import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.genconf.vo.NeedGenModel;

public class Confmanager {

	private static Confmanager manager = null;
	
	private Confmanager(GenConfImplementor provider){
		readConf(provider);
	}
	
	public static Confmanager getInstance(GenConfImplementor provider){
		if (manager == null) {
			manager = new Confmanager(provider);
		}
		return manager;
	}
	
	private GenConfModel genConf = new GenConfModel();
	private Map<String, ModuleConfModel> mapModuleConf = new HashMap<String, ModuleConfModel>();
	
	public GenConfModel getGenConf() {
		return this.genConf ;
	}

	public Map<String, ModuleConfModel> getMapModuleConf() {
		return this.mapModuleConf;
	}
	
	private void readConf(GenConfImplementor provider){
		////这里去真正的 获取配置数据
		readGenConf(provider);
		for(NeedGenModel ngm : genConf.getNeedGens()){
			readOneModuleGenConf(ngm);
		}
	}

	private void readOneModuleGenConf(NeedGenModel ngm) {
		ModuleConfModel mcm = new ModuleConfModel();
		String providerClassName = this.genConf.getThemeById(ngm.getTheme()).getMapproviders().get(ngm.getProvider());
		
		ModuleGenConfImplementor userGenConfImpl  = null;
		
		try {
			userGenConfImpl = (ModuleGenConfImplementor)Class.forName(providerClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mcm = userGenConfImpl.getBaseModuleConfModel(ngm.getMapParams());
		mcm.setUseTheme(ngm.getTheme());
		mcm.setMapExtends(userGenConfImpl.getMapExtends(genConf,ngm.getMapParams()));
		this.mapModuleConf.put(mcm.getModuleId(), mcm);
	
	}

	private void readGenConf(GenConfImplementor provider) {
		//然后把 获取到的配置数据 设置到属性上，缓存下来
		genConf.setNeedGens(provider.getNeedGens());
		genConf.setThemes(provider.getThemes());
		genConf.setMapConstants(provider.getMapConstants());
	}
	
}
