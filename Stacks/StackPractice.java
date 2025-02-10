import java.util.*;
public class StackPractice {
    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<>();
        nums.push(1);
        nums.push(2);
        nums.push(1);
        nums.push(6);
        nums.push(4);
        nums.push(3);

        System.out.println(countEvens(nums));
        System.out.println("Before: " + nums);
        removeEvens(nums);
        System.out.println("After: " + nums);
        
    }

    public static int countEvens(Stack<Integer> nums){
        if (nums == null){
            throw new IllegalArgumentException();
        }
        int count = 0;
        Stack<Integer> tempnums = new Stack<>();
        while(!nums.isEmpty()){
            int temp = nums.pop();
            if (temp % 2 == 0) {
                count++;                
            }
            tempnums.push(temp);
        }
        while (!tempnums.isEmpty()) {
            nums.push(tempnums.pop());
        }
        return count;
    }
    public static void removeEvens(Stack<Integer> nums){
        if (nums == null){
            throw new IllegalArgumentException();
        }
        int count = 0;
        Stack<Integer> tempnums = new Stack<>();
        while(!nums.isEmpty()){
            int temp = nums.pop();
            if (temp % 2 == 1) {
                tempnums.push(temp);               
            }
        }
        while (!tempnums.isEmpty()) {
            nums.push(tempnums.pop());
        }
    }

}
