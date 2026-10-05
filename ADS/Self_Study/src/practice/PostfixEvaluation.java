package practice;

public class PostfixEvaluation {
	public static class Stack {
		int[] stack;
		int size = 0;
		int top = -1;
		
		public Stack(int capacity) {
			stack = new int[capacity];
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean isFull() {
			return size == stack.length;
		}
		
		public void push(int item) {
			if(isFull())
				throw new IllegalStateException("Stack overflow");
			
			else {
				stack[++top] = item;
				size++;
			}
		}
		
		public int pop() {
			if(isEmpty())
				throw new IllegalStateException("Stack underflow");
			
			else {
				int item = stack[top--];
				size--;
				return item;
			}
		}
		
	}
	
	
	static int postfixEvaluation(String expression) {
		
		Stack stack = new Stack(20);
		
		String[] tokens = expression.split(" ");
		

		for(String token : tokens) {
			try {
				stack.push(Integer.parseInt(token));
			}
			catch(Exception e) {
				int b = stack.pop();
				int a = stack.pop();				

				int result = 0;
				
				switch(token) {
				
				case "+" : result =  a + b;break;
				case "-" : result = a - b;break;
				case "*" : result = a * b;break;
				case "/" : result = a / b;break;
				}
				
				stack.push(result);
			}
		}
		return stack.pop();
	}

	
	
	public static void main(String[] args) {

		String expression = "10 2 8 * + 3 -";
		
		System.out.println(postfixEvaluation(expression));
		
	}
	

}
