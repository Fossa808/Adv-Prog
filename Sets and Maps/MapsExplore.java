import java.util.*;
public class MapsExplore {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("left", "right");
        map.put("up", "down");
        map.put("forward", "backward");

        System.out.println(map);
        System.out.println(map.get("left"));
        System.out.println(map.get("down"));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.containsKey("forward"));
        System.out.println(map.containsKey("back"));

        map.put("up", "not up");
        System.out.println(map.get("up"));

        map.remove("left");
        System.out.println(map);

        map.remove("banana");
        System.out.println(map);

    }
}
