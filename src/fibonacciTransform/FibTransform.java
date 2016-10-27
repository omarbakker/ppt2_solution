package fibonacciTransform;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class FibTransform {

	/**
	 * Transform a number into a Fibonacci number using at most m steps: Of
	 * these steps, one can be a doubling step, and the other steps increase
	 * the number at hand by adding 1.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible_onlyOneDoubling(int n, int m) {
		
		boolean possible = false;
		for (int i = 0; i <= m; i++){
			if (isPossible_onlyOneDoubling(n,m,0,i))
				possible = true;
		}
		return possible;
	}

	public static boolean isPossible_onlyOneDoubling(int n, int m, int step,int multiplyAt) {
		if (step > m) return false;
		if (isFib(n)) return true;
		if (step == multiplyAt) return isPossible_onlyOneDoubling(n*2,m,step+1,multiplyAt);
		return isPossible_onlyOneDoubling(n+1,m,step+1,multiplyAt);
	}
	/**
	 * Transform a number into a Fibonacci number using at most m steps: One can
	 * use any sequence of doubling (*2) or addition (+1) steps as long as the
	 * total number of steps used is no more than m.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible(int n, int m) {
		return isPossible(n,m,0);
	}

	public static boolean isPossible(int n, int m, int step) {
		if (step > m) return false;
		if (isFib(n)) return true;
		return isPossible(n+1,m,step+1) || (isPossible(n*2,m,step+1));
	}
	
	/**
	 * Inspired from http://stackoverflow.com/questions/13336593/java-check-if-number-belongs-to-fibonacci-sequence
	 * because no time to think right now and this is guaranteed
	 * @param n
	 * @return
	 */
	public static boolean isFib(int n){
		if (n == 0) return true;
		int fib1 = 0;
	    int fib2 = 1;
	    do {
	        int saveFib1 = fib1;
	        fib1 = fib2;
	        fib2 = saveFib1 + fib2;
	        }
	    while (fib2 < n);

	    if (fib2 == n)
	        return true;
	    else
	        return false;
	}
	

}
