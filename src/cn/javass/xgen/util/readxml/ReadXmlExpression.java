package cn.javass.xgen.util.readxml;

public abstract class ReadXmlExpression implements Cloneable{

	public abstract String[] interpret(Context ctx);
	
	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
