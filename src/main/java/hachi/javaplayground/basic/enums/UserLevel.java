package hachi.javaplayground.basic.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserLevel {
    BASIC ("BA", "일반회원"),
    GOLD ("GD", "골드회원"),
    PLATINUM ("PL", "플래티넘");

    UserLevel(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    final static Map<String,UserLevel> map = new HashMap<>();

    static {
        for (UserLevel userLevel : UserLevel.values()) {
            map.put(userLevel.code, userLevel);
        }
    }

    public static UserLevel findByCode(String code) {
        return map.get(code);
    }
}