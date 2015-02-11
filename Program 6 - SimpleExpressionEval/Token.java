/**
 * A class that abstracts a term of an expression, like operators, operands and delimiters
 * 
 * @author Andy Gajadhar
 * @since October 13, 2014
 *
 */

public class Token {
	private String value;    // the term itself
	private Type type;    // the type of the term
	
	public Token(){
		value = null;
		type = null;
	}
	//accessors and mutators
	public Token(String v, Type t){
		value = v;
		type = t;
	}
	
	public Type getType(){
		return this.type;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setType(Type t){
		type = t;
	}
	
	public void setValue(String v){
		value = v;
	}
	
	
}
