package practice;

public class BalancedBrackets {

	public static class Stack <T> {
		Object[] stack;
		int top = -1;
		int size = 0;
		
		Stack(int capacity) {
			stack = new Object[capacity];
		}
		
		boolean isEmpty() {
			return size == 0;
		}
		
		boolean isFull() {
			return size == stack.length;
		}
		
		public void push(T item) {
			if(isFull())
				throw new IllegalStateException("Overflow!!");
			stack[++top] = item;
			size++;
		}
		
		@SuppressWarnings("unchecked")
		 public T pop() {
			 if(isEmpty())
				 throw new IllegalStateException("");
			 T item = (T) stack[top--];
			 size--;
			 return item;
		 }
	}
	
	public static boolean isBalanced(String str) {
		
		Stack<Character> stack = new Stack<>(10);
		
		if(str == null)
			return false;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(' || ch =='{' || ch == '[' || ch == '<')
				stack.push(ch);
			
			if(ch == ')' || ch == '}' || ch ==']' || ch == '>') {
				if(stack.isEmpty())
					return false;
				
				char top = stack.pop();
				
				if(ch == '}' && top != '{')
					return false;
				if(ch == ']' && top != '[')
					return false;
				if(ch == ')' && top != '(')
					return false;
				if(ch == '>' && top != '<')
					return false;
				
			}
			
		}
		return stack.isEmpty();
	}
	
	
	public static void main(String[] args) {
		
		String str = "()Viswajith{CDAC}";
		
		System.out.println(isBalanced(str));
		
	}
	
}
