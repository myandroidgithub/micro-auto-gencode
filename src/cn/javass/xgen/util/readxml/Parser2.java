package cn.javass.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Parser2 {

	//定义常量
	private static final String BACKLASH = "/";
	private static final String DOT = ".";
	private static final String DOLLAR = "$";

	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";

	/**
	 * 按照分解的先后顺序的元素名称
	 */
	private static List<String> listEle = null;
	
	private Parser2(){
		
	}
	
	public static ReadXmlExpression parse(String expr){
		listEle = new ArrayList<String>();
		//第一大步：分解表达式，得到需要解析的元素名称和该元素对应的解析模型
		Map<String,ParseModel> mapPath = parseMapPath(expr);
		//第二大步：根据元素对应的解析模型 --〉转换成相应的解释器对象
		List<ReadXmlExpression> list = mapPath2Expression(mapPath);
		// 第三大步：按照先后顺序组成成为抽象语法树
		ReadXmlExpression retTree = buildTree(list);
		return retTree;
	}

	////////////////////////////////第一大步/////////////////////////
	private static Map<String, ParseModel> parseMapPath(String expr) {
		Map<String, ParseModel> mapPath = new HashMap<String, ParseModel>();
		StringTokenizer tokenizer = new StringTokenizer(expr, BACKLASH);
		while (tokenizer.hasMoreTokens()) {
			String onepath = tokenizer.nextToken();
			if (tokenizer.hasMoreTokens()) {
				//说明不是结尾
				setParseModel(onepath,false,false,mapPath);
			}else {
				int dotIndex = onepath.indexOf(DOT);
				//属性结尾
				if (dotIndex > 0) {
					
					String eleName = onepath.substring(0, dotIndex);
					String propName = onepath.substring(dotIndex+1);
					
					//设置属性前面的元素
					setParseModel(eleName, false, false, mapPath);
					//设置属性
					setParseModel(propName, true, true, mapPath);
					
				}else {
					//元素结尾
					setParseModel(onepath, false, true, mapPath);
				}
			}
		}
		return mapPath;
	}
	private static void setParseModel(String eleName, boolean propertyValue, boolean end, Map<String, ParseModel> mapPath) {
		
		ParseModel pm = new ParseModel();
		pm.setEnd(end);
		pm.setPropertyValue(propertyValue);
		pm.setSingleValue(!(eleName.indexOf(DOT) > 0));
		
		//去掉$
		eleName = eleName.replace(DOLLAR, "");
		
		int tempBegin = 0;
		int tempEnd = 0;
		
		if ((tempBegin=eleName.indexOf(OPEN_BRACKET))>0) {
			tempEnd = eleName.lastIndexOf(CLOSE_BRACKET);
			String condition = eleName.substring(tempBegin+1, tempEnd);
			
			pm.setCondition(condition);
		}
		
		pm.setEleName(eleName);
		
		mapPath.put(eleName, pm);
		
		listEle.add(eleName);
	}

	////////////////////////////////第二大步/////////////////////////
	private static List<ReadXmlExpression> mapPath2Expression(Map<String, ParseModel> mapPath) {
		//一定要按照分解的先后顺序来转换成相应的解释器对象
		List<ReadXmlExpression> list = new ArrayList<ReadXmlExpression>();
//		Set<String> set = mapPath.keySet();//这里和视频上写的区别 视频上在上一步add进list 是不是好一些？
		for (String key : listEle) {
			ParseModel pm = mapPath.get(key);
			ReadXmlExpression obj = parseModel2ReadXmlExpression(pm);
			list.add(obj);
		}
		return list;
	}
	
	private static ReadXmlExpression parseModel2ReadXmlExpression(ParseModel pm) {
		
		ReadXmlExpression re = null;

		if (!pm.isEnd()) {
			if (pm.isSingleValue()) {
				re = new ElementExpression(pm.getEleName(), pm.getCondition());
			} else {
				re = new ElementsExpression(pm.getEleName(), pm.getCondition());
			}
		} else {
			if (pm.isPropertyValue()) {
				if (pm.isSingleValue()) {
					re = new PropertyTerminalExpression(pm.getEleName());
				} else {
					re = new PropertysTerminalExpression(pm.getEleName());
				}
			} else {
				if (pm.isSingleValue()) {
					re = new ElementExpression(pm.getEleName(), pm.getCondition());
				} else {
					re = new ElementsExpression(pm.getEleName(), pm.getCondition());
				}
			}
		}
		return re;
	}

	////////////////////////////////第三大步/////////////////////////
	private static ReadXmlExpression buildTree(List<ReadXmlExpression> list) {
		
		// 第一个对象，根对象，也就是返回去的对象
		ReadXmlExpression retRe = null;
		// 用来临时记录上一个元素，就是父元素
		ReadXmlExpression preRe = null;
		
		for (ReadXmlExpression re : list) {
			
			if (preRe == null) {
				retRe = re;
				preRe = re;
			}else {
				if (preRe instanceof ElementExpression) {
					ElementExpression ele = (ElementExpression)preRe;
					ele.addEle(re);
					
					preRe = re;
				}else if(preRe instanceof ElementsExpression){
					ElementsExpression eles = (ElementsExpression)preRe;
					eles.addEle(re);
					
					preRe = re;
				}
			}
		}
		return retRe;
	}
}