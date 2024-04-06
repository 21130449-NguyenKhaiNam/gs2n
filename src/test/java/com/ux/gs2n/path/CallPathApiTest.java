package com.ux.gs2n.path;

import com.ux.gs2n.dao.properties.EManagerPathApi;
import com.ux.gs2n.dao.properties.PathApiDao;

public class CallPathApiTest {
    public static void main(String[] args) {
        System.out.println(PathApiDao.getInstance().getPath(EManagerPathApi.LOGIN));
    }
}
