package day4;


class Recursion {

    static void print(int n) {
        if(n == 0) 
            return;

        System.out.println(n);
        print(n - 1);
    }


    static long factorial(int num) {
        if(num == 1)
            return 1;
        return factorial(num - 1);
    }

    static int sum(int num) {
        if(num == 0)
            return 0;
        return num + sum(num - 1);
        
    }

    static long fibonacci(int num) {
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;

        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    static void countDown(int n) {
        if(n == 0)
            return;
        System.out.println(n);
        countDown(n - 1);
    }

    static long sumDigit(int n) {
        if(n == 0) 
            return 0;

        int rem = n % 10;
        n /= 10;

        return rem + sumDigit(n);


    }
    
    static String reverseString(String str) {
    	if(str.length() <= 1)
    		return str;
    	return reverseString(str.substring(1)) + str.charAt(0);
    }


    public static void main(String[] args) {

        // print(5);

        // System.out.print(factorial(5));

        System.out.println(sumDigit(123129823));
    }
}