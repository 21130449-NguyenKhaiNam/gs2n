package com.ux.gs2n.dao.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PathApiDao implements IPropertiesDao {
    private static PathApiDao path;
    private final Map<String, String> managerPath;

    private PathApiDao() {
        managerPath = new HashMap<>();
        try {
            InputStream is = PathApiDao.class.getClassLoader().getResourceAsStream(EManagerPathApi.PATH_PROPERTIES.getValue());
            properties.load(is);
            properties.forEach((k, v) -> {
                managerPath.put(k.toString(), v.toString());
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PathApiDao getInstance() {
        return path == null ? (path = new PathApiDao()) : path;
    }

    @Override
    public String getPath(IManagerEnumPath enumPath) {
        return managerPath.get(enumPath.getValue());
    }
}
