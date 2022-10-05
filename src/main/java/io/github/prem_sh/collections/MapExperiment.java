package io.github.prem_sh.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExperiment {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Git","VCS");
        map.put("Spring","Framework");
        map.put("React","Frontend");
        map.put("Postgres","DB");
        for (Map.Entry<String, String> e: map.entrySet()) {
            System.out.println(e.getKey()+" : "+e.getValue());
        }
    }
}
