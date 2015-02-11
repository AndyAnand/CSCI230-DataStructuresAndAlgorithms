import java.util.ArrayList;

/**
 * This class provides two evaluator methods for in order form expressions, one that evaluates as floating point and another as integer,
 * accepting negative and real numbers.
 * 
 * Pre-requisites: the whole expression is enclosed by parenthesis and only the +,-,/,* operators are accepted.
 * 
 * @author Andy Gajadhar
 * @since October 12, 2013
 */

public class Evaluator {
	private static StackL<Token> expr = new StackL<>();    // stores the read tokens before a ')' happen
	
	/**
	 * evalF evaluates a expression and returns its value as a floating point number. It first parses the expression in 
	 * terms (tokens) and then process each subexpression, considering precedence of operators and order of evaluation.
	 * 
	 * @param exp an expression
	 * @return the result of the expression evaluation
	 */
	
	public static float evalF(String exp){
		
		exp = exp.replace(" ", "");    //remove blank spaces
		
		float value = 0;    //the result of the expression
		
		Token[] terms = (Token[]) parser(exp).toArray(new Token[parser(exp).size()]);    // obtain the terms of the expression
		
		for(Token c : terms){
			if(!c.getValue().equals(")")){    //while ')' not found, we dont have a subexpression to process, so keeps storing the terms in the stack
				expr.push(c);
			}else{    // a ')' was found, process the last sub expression
				//evaluate sub exp, that is, pop until find a '(' and call a method to eval taking in account the precedences rules(* / first, then + -)
				value = evalSubExp(getSubExp());
				expr.push(new Token(Float.toString(value), Type.NUMBER));    //stores the sub expression value in the stacks
			}
		}
		
		return value;
	}
	
	/**
	 * parser receives an exp without blank spaces, classify the terms as numbers, delimiters or operators and creates an ArrayList with the Tokens objects
	 * to be returned.
	 * 
	 * @param exp a expression
	 * @return an ArrayList of Tokens
	 */
	
	private static ArrayList<Token> parser(String exp){
		String word = "";
		ArrayList<Token> tokens = new ArrayList<>();
		int cursor = 0;
		
		char[] expChars = exp.toCharArray();
		boolean canBeNegSignal = false;    // useful for detecting a negative number 
		
		while(cursor < expChars.length){
			if(expChars[cursor] == '(' || expChars[cursor] == ')'){    //its a delimiter
				tokens.add(new Token(expChars[cursor]+"", Type.DELIMITER));
				
				if(expChars[cursor] == ')'){
					canBeNegSignal = false;    // after a closing parenthesis, is not possible to have a number
				}else{
					canBeNegSignal = true;
				}
				cursor++;
			}else if(canBeNegSignal){    // a number, int or float, positive or negative
				//searchs for the entire number
				if(expChars[cursor] == '-'){    //its a negative number
					word = "-";
					cursor++;
				}
				
				while((expChars[cursor]+"").matches("[0-9|\\.]")){
					word += expChars[cursor++];
				}
				
				tokens.add(new Token(word, Type.NUMBER));
				word = "";
				canBeNegSignal = false;
				
			}else{    // its an operator
				tokens.add(new Token(expChars[cursor]+"", Type.OPERATOR));
				cursor++;
				canBeNegSignal = true;    //indicates for the next iteration that a neg number can be found
				
			}
		}
		
		return tokens;
	}
	
	/**
	 * getSubExp gets a subExp from the expr stack.
	 * @return an ArrayList of Token representing the sub expression removed from the stack
	 */
	
	private static ArrayList<Token> getSubExp(){
		ArrayList<Token> subExp = new ArrayList<>();
		
		while(!expr.peak().getValue().equals("(")){
			subExp.add(expr.pop());   
		}
		
		expr.pop();    //removing the '('
		
		return subExp;
	}
	
	/**
	 * evalSubExp evaluates a sub expression represented as an ArrayList of Token objects,
	 * (*) and (/) are performed first and from left to right (right to left because of the stacks inverted order).
	 * 
	 * @param subExp an ArrayList of Token objects representing a sub expression
	 * @return the resulting value of this sub expression
	 */
	
	private static float evalSubExp(ArrayList<Token> subExp){

		float op1,op2;
		
		int numOp = 0;    // the number of operations * or / to be performed
		
		for(int i = 0; i < subExp.size(); i++){
			//System.out.print("|"+subExp.get(i).getValue() + "| ");
			if(subExp.get(i).getValue().matches("[*|/]"))
				numOp++;
		}
		//System.out.println("");
		while(numOp != 0){
			for(int i = subExp.size() - 1; i >= 0; i--){    //from right to left, because of the stack`s LIFO order
				
				//performing * and / first
				if(subExp.get(i).getType() == Type.OPERATOR && subExp.get(i).getValue().matches("[*|/]")){
					
					op2 = Float.parseFloat(subExp.get(i - 1).getValue());
					op1 = Float.parseFloat(subExp.get(i + 1).getValue());
					if(subExp.get(i).getValue().equals("*")){
						op1 = op1 * op2;
					}else
						op1 = op1 / op2;
					
					//now, the operator and the operands of the solved subExp will be replaced by the resulting value
					subExp.remove(i+1);
					subExp.remove(i);
					subExp.remove(i-1);
					subExp.add(i-1, new Token(Float.toString(op1), Type.NUMBER));
					numOp--;
					break;
				}
			}
			
		}
		
		//counting the number of + and - operations
		for(int i = 0; i < subExp.size(); i++){
			if(subExp.get(i).getValue().matches("[+|-]"))
				numOp++;
		}
		
		while(numOp != 0){
			for(int i = subExp.size() - 1; i >= 0; i--){
				//performing + and - operations
				if(subExp.get(i).getType() == Type.OPERATOR && subExp.get(i).getValue().matches("[+|-]")){
					op2 = Float.parseFloat(subExp.get(i - 1).getValue());    //op2 is the first one because of the stacks order. e.g: (1 + 2) is recovered as (2 + 1) from the stack, int subtraction and division, if you dont track this, the result can be wrong
					op1 = Float.parseFloat(subExp.get(i + 1).getValue());
					if(subExp.get(i).getValue().equals("+")){
						op1 = op1 + op2;
					}else
						op1 = op1 - op2;
					
					//now, the operator and the operands of the solved subExp will be replaced by the resulting value
					subExp.remove(i+1);
					subExp.remove(i);
					subExp.remove(i-1);
					subExp.add(i-1, new Token(Float.toString(op1), Type.NUMBER));
					numOp--;
					break;
				}
			}
			
		}
		
		//System.out.println(Float.parseFloat(subExp.get(0).getValue()));    
		
		return Float.parseFloat(subExp.get(0).getValue());    //the result will be at index 0 of the arraylist, always
	}
	
	/**
	 * evalI evaluates a expression and returns its value as a integer number. It first parses the expression in 
	 * terms (tokens) and then process each subexpression, considering precedence of operators and order of evaluation.
	 * 
	 * @param exp an expression
	 * @return the result of the expression evaluation
	 */
	
	public static int evalI(String exp){
		return (int) evalF(exp);
	}
	
	//tests
	
	public static void main(String[] args){
		System.out.println("Resultado: "+Evaluator.evalF("((1 + -2)/15)")); //(((1 + 2) * 2)/3)   //((((1 + 2) * 2)/-1)*150 + 30)   // ((((1 + -2.34234) * 2)/-1)*150 + 30)
	}
}
