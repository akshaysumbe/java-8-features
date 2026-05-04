package streams.practice;

import streams.practice.model.User;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomCollector {
    static void main() {
        LinkedHashMap<Object, Object> linkedHashMap = User.users().stream()
                .collect(
                        LinkedHashMap::new,//supplier
                        (map, user) -> map.put(user.getId(), user),//accumulator
                        Map::putAll//merge function
                );
    }
}
