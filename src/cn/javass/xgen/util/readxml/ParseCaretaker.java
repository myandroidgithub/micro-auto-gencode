package cn.javass.xgen.util.readxml;

public class ParseCaretaker {

	public static ParseCaretaker caretaker = new ParseCaretaker();
	private ParseCaretaker(){
		
	}
	
	private ParseMemento memento = null;
	
	public static ParseCaretaker getInstance(){
		return caretaker;
	}
	
	public void setMemento(ParseMemento memento){
		this.memento = memento;
	}
	
	public ParseMemento retriveMemento(){
		return this.memento;
	}
}
