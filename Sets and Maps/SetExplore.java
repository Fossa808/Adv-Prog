import java.util.*;
public class SetExplore {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("whs");
        set.add("bhs");
        set.add("ihs");
        set.add("nchs");
        for(int i = 0; i < 5; i++){
            set.add("whs");
        }
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains("ihs"));
        System.out.println(set.remove("rhs"));
        set.clear();
        System.out.println(set);
        System.out.println(set.remove("ihs"));
    }
}
