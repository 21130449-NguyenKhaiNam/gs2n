package com.ux.gs2n.dao.properties;

public enum EManagerPathApi implements IManagerEnumPath {
    PATH_PROPERTIES("api.properties"),
    LOGIN("api.auth.login");
    private final String value;

    EManagerPathApi(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
