package fibonacci;

/** In mathematics, the Fibonacci numbers, commonly denoted Fn form a sequence, 
called the Fibonacci sequence, such that each number is the sum of the two preceding ones, 
starting from 0 and 1

 * Complexity : O(2^n)
 * 
     T(n) = T(n-1) + T(n-2) <
     T(n-1) + T(n-1) 

     = 2*T(n-1)   
     = 2*2*T(n-2)
     = 2*2*2*T(n-3)
     ....
     = 2^i*T(n-i)
     ...
     ==> O(2^n)

*/
public class Fibonacci {
	
	public static int fibonacci(int n) {
	    if (n <= 1)
	        return n;
	    return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(8));

	}

}
