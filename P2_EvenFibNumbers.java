import java.util.HashMap;
import java.util.Map;

/**
 * Created by jdub on 10/04/17.
 *
 * Even Fibonacci numbers
 Problem 2

 Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

 By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 *
 */
public class P2_EvenFibNumbers implements Solution{
    HashMap<Integer,Integer> dir;

    /**
     * WORKS, however there is LOTS of room for improvement.
     * concepts to work with:  -'the golden ratio'
     *                         -the odd, odd, even pattern observed in fib numbers
     *                         -replacing the method with a simple loop (time both, learn!)
     * @return
     */
    private long BruteForce(){
        long sum = 0;
        dir = new HashMap<>();
        dir.put(1,1);
        dir.put(2,1);
        int fibOutcome = 0;
        int count = 3;
        while(fibOutcome < 4000000) {
           fibOutcome = fib(count++);
           if(fibOutcome % 2 == 0)
               sum += fibOutcome;
        }
        return sum;
    }

    private int fib(int i) {
        if(dir.get(i) == null)
            dir.put(i,fib(i-1) + fib(i-2));
        return dir.get(i);
    }


    @Override
    public Object getSolution() {
        return String.valueOf(BruteForce());
    }
}
