package cloud.simple.web;

import java.util.concurrent.ConcurrentHashMap;


public enum EnvEnum {

    dev(1,"dev", "默认环境"),
    test(2,"test", "测试环境"),
    pre(3,"pre", "预发环境"),
    prod(4,"prod", "生产环境");

    private Integer id;
    private String code;
    private String desc;

    EnvEnum(Integer id, String code, String desc) {
        this.code = code;
        this.desc = desc;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public static final ConcurrentHashMap<String, String> DICTIONARY = new ConcurrentHashMap();

    static {
        for (EnvEnum e : EnvEnum.values()) {
            DICTIONARY.put(e.getCode(), e.getDesc());
        }
    }



    public static String getDescByCode(String code){
        return DICTIONARY.get(code);
    }

    public static String getDescById(Integer id){
        if (id == null ) {
            return "";
        }
        for (EnvEnum value : values()) {
            if (value.getId() == id) {
                return value.getDesc();
            }
        }
        return "";
    }
}

