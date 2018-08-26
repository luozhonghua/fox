package com.st.fox.admin.service.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by luozhonghua on 2018/8/25.
 */
public class BeanToMapUtilTest {
    @Test
    public void listToTree() throws Exception {

        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("pid",0);
        map.put("name","甘肃省");
        data.add(map);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("id",2);
        map2.put("pid",1);
        map2.put("name","天水市");
        data.add(map2);
        Map<String,Object> map3 = new HashMap<>();
        map3.put("id",3);
        map3.put("pid",2);
        map3.put("name","秦州区");
        data.add(map3);
        Map<String,Object> map4 = new HashMap<>();
        map4.put("id",4);
        map4.put("pid",0);
        map4.put("name","北京市");
        data.add(map4);
        Map<String,Object> map5 = new HashMap<>();
        map5.put("id",5);
        map5.put("pid",4);
        map5.put("name","昌平区");
        data.add(map5);
        System.out.println(JSON.toJSONString(data));
        JSONArray result = BeanToMapUtil.listToTree(JSONArray.parseArray(JSON.toJSONString(data)),"id","pid","children");
        System.out.println(JSON.toJSONString(result));
    }

}