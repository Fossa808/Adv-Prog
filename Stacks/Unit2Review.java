import java.util.*;
public class Unit2Review {
    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<>();
        nums.push(3);
        nums.push(8);
        nums.push(17);
        nums.push(9);
        nums.push(99);
        nums.push(9);
        nums.push(17);
        nums.push(8);
        nums.push(3);
        nums.push(1);
        nums.push(2);
        nums.push(3);
        nums.push(4);
        nums.push(14);
        System.out.println(nums);
        switchPairs(nums);
        System.out.println(nums);
    }

    public static void switchPairs (Stack<Integer> nums){
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Queue<Integer> backup = new LinkedList<>();
        int size = nums.size();
        if(size % 2 == 1) {
            backup.add(nums.pop());
            size--;
        }
        int temp = 0;
        for(int i = 0; i < size; i+=2) {
            temp = nums.pop();
            backup.add(nums.pop());
            backup.add(temp);
        }
        while(!backup.isEmpty()) {
            nums.push(backup.remove());
        }
        while(!nums.isEmpty()) {
            backup.add(nums.pop());
        }
        while(!backup.isEmpty()) {
            nums.push(backup.remove());
        }
        
    }

    public static int removeMin(Stack<Integer> nums){
        return -1;
    }
}
