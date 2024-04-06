package com.ux.gs2n.dao.properties;

import java.util.Properties;

public interface IPropertiesDao {
    Properties properties = new Properties();

    String getPath(IManagerEnumPath enumPath);
}
