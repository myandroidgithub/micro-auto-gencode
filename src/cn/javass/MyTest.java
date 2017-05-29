package cn.javass;

import cn.javass.xgen.util.readxml.Context;
import cn.javass.xgen.util.readxml.ElementExpression;
import cn.javass.xgen.util.readxml.ElementTerminalExpression;
import cn.javass.xgen.util.readxml.ElementsExpression;
import cn.javass.xgen.util.readxml.ElementsTerminalExpression;
import cn.javass.xgen.util.readxml.Parser;
import cn.javass.xgen.util.readxml.PropertyTerminalExpression;

public class MyTest {

	public static void main(String[] args) throws Exception {
		
		ElementExpression genConf = new ElementExpression("GenConf", "");
		ElementExpression constants = new ElementExpression("Constants", "");
		ElementsTerminalExpression constant = new ElementsTerminalExpression("Constant", "");
		
//		ElementExpression param = new ElementExpression("Param", "");
//		PropertyTerminalExpression id = new PropertyTerminalExpression("id");
		
		//组装抽象语法树
		genConf.addEle(constants);
		constants.addEle(constant);
		
//		param.addEle(id);
		
		Context ctx = Context.getInstance("cn/javass/xgenconfxml/GenConf.xml");
		
		String[] ss = genConf.interpret(ctx);
		
		for (String s : ss) {
                    
		    System.out.println(s);
                }
		
		
//		String [] ss = null;
////		for(int i=0;i<1000;i++){
//			 ss = Parser.parse("GenConf/NeedGens/NeedGen/Params/Param$").interpret(ctx);
////			String [] ss2 = Parser.parse("GenConf/NeedGens/NeedGen/Params/Param$.id$").interpret(ctx);
////		}
//		
//		for (String srr : ss) {
//		    System.out.println("s=="+srr);
//		}
	}
}
