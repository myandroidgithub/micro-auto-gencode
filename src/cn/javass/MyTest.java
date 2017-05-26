package cn.javass;

import cn.javass.xgen.util.readxml.Context;
import cn.javass.xgen.util.readxml.ElementExpression;
import cn.javass.xgen.util.readxml.ElementsExpression;
import cn.javass.xgen.util.readxml.ElementsTerminalExpression;
import cn.javass.xgen.util.readxml.Parser;

public class MyTest {

	public static void main(String[] args) throws Exception {
		
//		ElementExpression genConf = new ElementExpression("GenConf", "");
//		ElementExpression needGens = new ElementExpression("NeedGens", "");
//		ElementsExpression needGen = new ElementsExpression("NeedGen", "");
//		ElementsExpression params = new ElementsExpression("Params", "");
//
//		ElementsTerminalExpression param = new ElementsTerminalExpression("Param", "id=fileName2");
//		
//		//组装抽象语法树
//		genConf.addEle(needGens);
//		needGens.addEle(needGen);
//		needGen.addEle(params);
//		params.addEle(param);
//		
		Context ctx = Context.getInstance("cn/javass/xgenconfxml/GenConf.xml");
		
		String [] ss = null;
//		for(int i=0;i<1000;i++){
			 ss = Parser.parse("GenConf/NeedGens/NeedGen/Params/Param$").interpret(ctx);
//			String [] ss2 = Parser.parse("GenConf/NeedGens/NeedGen/Params/Param$.id$").interpret(ctx);
//		}
		
		for (String s : ss) {
			System.out.println("s=="+s);
		}
	}
}
