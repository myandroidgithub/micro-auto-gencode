package cn.javass.xgen.genconf;

import cn.javass.xgen.genconf.implementor.GenConfImplementor;

public class GenConfFactory {

	private GenConfFactory(){
		
	}
	
	public static GenConfEbi createGenConfEbi(GenConfImplementor provider){
		return GenConfEbo.getInstance(provider);
	}
	
}
