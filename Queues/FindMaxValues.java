import java.util.*;
public class FindMaxValues {
    public static void main(String[] args) {
        Queue<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(3);
        nums.add(5);
        System.out.println(findMaxValue(nums));
        System.out.println(nums);
    }

    public static int findMaxValue(Queue<Integer> nums){
        Queue<Integer> temp = new LinkedList<>();
        int max = nums.peek();
        while (!nums.isEmpty()) {
            if (nums.peek() > max){
                max = nums.peek();
            }
            temp.add(nums.remove());
        }
        while (!temp.isEmpty()) {
            nums.add(temp.remove()); 
        }
        return max;
    }
}
