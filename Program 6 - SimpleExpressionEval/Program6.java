import java.util.Iterator;
import java.util.Scanner;
/**
 * This class is the main class of Program 6, it builds an expression tree, do the traversals and evaluates the expression
 * 
 * @author Andy Gajadhar
 *
 * @param <E>
 */
public class Program6<E> {
	
	/**
	 * run runs the tasks asked in the program6 specification
	 */
	
	public void run(){
		Scanner keyboard = new Scanner(System.in);
		String exp;
		BinaryTree<E> expTree;
		String inOrderExp = "";
		
		System.out.print("Enter an expression: ");
		exp = keyboard.next();
		expTree = new BinaryTree<>(exp);    //build the expression tree
		
		Iterator<E> i = expTree.preOrder().iterator();
		System.out.print("Preorder: ");
		
		while(i.hasNext()){
			System.out.print(i.next()+" ");    //preorder
		}
		
		i = expTree.inOrder().iterator();
		
		System.out.println();
		
		System.out.print("Inorder: ");
		while(i.hasNext()){
			inOrderExp += i.next().toString() + " ";
		}
		System.out.print(inOrderExp);	//inorder
		i = expTree.postOrder().iterator();
		
		System.out.println();
		
		System.out.print("Postorder: ");
		while(i.hasNext()){
			System.out.print(i.next()+" ");    //postorder
		}
		System.out.println();
		System.out.println("Evaluates to " + Evaluator.evalI(inOrderExp));    //evaluates the inOrder form expression of the tree as an integer
		//System.out.println("Evaluates to " + Evaluator.evalF(inOrderExp));    //evaluates the inOrder form expression of the tree as a float
		keyboard.close();
	}
	
	public static void main(String[] args){
		new Program6<String>().run();
	}
}
