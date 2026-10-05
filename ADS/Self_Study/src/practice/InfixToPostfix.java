package practice;

public class InfixToPostfix {
	public static class Stack{
		char[] stack;
		int size = 0;
		int top = -1;
		
		public Stack(int capacity) {
			stack = new char[capacity];
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean isFull() {
			return size == stack.length;
		}
		
		public void push(char item) {
			if(isFull())
				throw new IllegalStateException("Overflow");
			
			stack[++top] = item;
			size++;
		}
		
		public char pop() {
			if(isEmpty()) 
				throw new IllegalStateException("Underflow");
			
			char item = stack[top--];
			size--;
			return item;
		}
		
		public char peek() {
			return stack[top];
		}
	}
	
	
	public static int precedence(char operator) {
		switch(operator) {
		case '+' :
		case '-' :
			return 1;
			
		case '/':
		case '*':
			return 2;
		
		}
		return 0;
	}
	
	public static String infixToPostfix(String expression) {
		Stack stack = new Stack(20);
		StringBuilder result = new StringBuilder();
		
		for(char token : expression.toCharArray()) {
			if(Character.isLetterOrDigit(token))
				result.append(token);
			
			else if(token == '(') {
				stack.push('(');
			}
			
			else if(token == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				stack.pop();
			}
			
			//OPERATOR
			else {
				while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
					result.append(stack.pop());
				}
				stack.push(token);
			}
		}
		while(!stack.isEmpty())
			result.append(stack.pop());
		
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		String expression = "A+B*C";
		
		System.out.println(infixToPostfix(expression));
	}
}
