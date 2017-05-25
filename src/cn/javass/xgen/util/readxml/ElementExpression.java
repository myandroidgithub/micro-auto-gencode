package cn.javass.xgen.util.readxml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class ElementExpression extends ReadXmlExpression{

	/**
	 * 用来记录组合的子ReadXmlExpression元素
	 */
	private List<ReadXmlExpression> eles = new ArrayList<ReadXmlExpression>();
	
	public void setEles(List<ReadXmlExpression> eles) {
		this.eles = eles;
	}
	
	public List<ReadXmlExpression> getEles() {
		return eles;
	}
	
	/**
	 * 元素的名称
	 */
	private String eleName = "";
	
	/**
	 * 判断的条件
	 */
	private String condition = "";
	
	public ElementExpression(String eleName, String condition) {
		super();
		this.eleName = eleName;
		this.condition = condition;
	}

	public void addEle(ReadXmlExpression ele){
		this.eles.add(ele);
	}
	public boolean removeEle(ReadXmlExpression ele){
		this.eles.remove(ele);
		return true;
	}
	
	public void removeAllEles(){
		this.eles.clear();
	}

	@Override
	public String[] interpret(Context ctx) {
	
		//1.维护父级节点
		//1.1先取出父元素
		List<Element> pEles = ctx.getPreEles();
		
		Element ele = null;
		
		List<Element> nowEles = new ArrayList<Element>();
 		if (pEles.size() == 0) {
 			//1.2   判断父元素是否存在，如果不存在，表示是根元素
 			ele = ctx.getDocument().getDocumentElement();
 			pEles.add(ele);
		}else {
			//1.3   如果存在，那么就应该 找到当前表达式所对应的元素，把这个元素设置成父级节点
			for (Element pEle : pEles) {
				nowEles.addAll(ctx.getNowEles(pEle, eleName));
				if (nowEles.size()>0) {
					//找到一个就停止
					break;
				}
			}
			
			if (nowEles.size()>0 && ctx.judgeCondition(nowEles.get(0), condition)) {
	 			List<Element> tempList = new ArrayList<Element>();
				tempList.add(nowEles.get(0));
				ctx.setPreEles(tempList);
			}
		}
		
 		//2：循环解释子元素		
		String ss[] = null;

		for (ReadXmlExpression tempEle : eles) {
			ss = tempEle.interpret(ctx);
		}
		return ss;
	}
}
