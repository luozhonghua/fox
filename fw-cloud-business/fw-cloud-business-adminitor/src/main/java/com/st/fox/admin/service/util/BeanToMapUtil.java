package com.st.fox.admin.service.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;  
  

public class BeanToMapUtil {
	/** 
     * 将一个 Map 对象转化为一个 JavaBean 
     *  
     * @param type 
     *            要转化的类型 
     * @param map 
     *            包含属性值的 map 
     * @return 转化出来的 JavaBean 对象 
     * @throws IntrospectionException 
     *             如果分析类属性失败 
     * @throws IllegalAccessException 
     *             如果实例化 JavaBean 失败 
     * @throws InstantiationException 
     *             如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 
     *             如果调用属性的 setter 方法失败 
     */  
    public static Object convertMap(Class<?> type, Map<String, Object> map)  
            throws IntrospectionException, IllegalAccessException,  
            InstantiationException, InvocationTargetException {  
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性  
        Object obj = type.newInstance(); // 创建 JavaBean 对象  
  
        // 给 JavaBean 对象的属性赋值  
        PropertyDescriptor[] propertyDescriptors = beanInfo  
                .getPropertyDescriptors();  
        for (int i = 0; i < propertyDescriptors.length; i++) {  
            PropertyDescriptor descriptor = propertyDescriptors[i];  
            String propertyName = descriptor.getName();  
  
            if (map.containsKey(propertyName)) {  
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。  
                Object value = map.get(propertyName);  
  
                Object[] args = new Object[1];  
                args[0] = value;  
  
                descriptor.getWriteMethod().invoke(obj, args);  
            }  
        }  
        return obj;  
    }  
  
    /** 
     * 将一个 JavaBean 对象转化为一个 Map
     * "child":[],
     *  
     * @param bean 
     *            要转化的JavaBean 对象 
     * @return 转化出来的 Map 对象 
     * @throws IntrospectionException 
     *             如果分析类属性失败 
     * @throws IllegalAccessException 
     *             如果实例化 JavaBean 失败 
     * @throws InvocationTargetException 
     *             如果调用属性的 setter 方法失败 
     */  
    public static Map<String, Object> convertBean(Object bean)  {  
        Class<?> type = bean.getClass();  
        Map<String, Object> returnMap = new HashMap<String, Object>();  
        BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			 PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		        for (int i = 0; i < propertyDescriptors.length; i++) {  
		            PropertyDescriptor descriptor = propertyDescriptors[i];  
		            String propertyName = descriptor.getName();
		             System.out.println("-----propertyName:"+propertyName);
		            if (!propertyName.equals("class")) {  
		                Method readMethod = descriptor.getReadMethod();  
		                Object result = readMethod.invoke(bean, new Object[0]);
                        System.out.println("-----result:"+FastJsonUtils.toString(result)+" readMethod:"+FastJsonUtils.toString(readMethod));
		                if (result != null) {  
		                    returnMap.put(propertyName, result);  
		                } else {
		                    returnMap.put(propertyName, "");  
		                }
		            }  
		        }  
		} catch (Exception e) {
			e.printStackTrace();
		}  
        return returnMap;  
    }

    /**
     * listToTree
     * <p>方法说明<p>
     * 将JSONArray数组转为树状结构
     * @param arr 需要转化的数据
     * @param id 数据唯一的标识键值
     * @param pid 父id唯一标识键值
     * @param child 子节点键值
     * @return JSONArray
     */
    public static JSONArray listToTree(JSONArray arr, String id, String pid, String child){
        JSONArray r = new JSONArray();
        JSONObject hash = new JSONObject();
       try {
           //将数组转为Object的形式，key为数组中的id
           for (int i = 0; i < arr.size(); i++) {
               JSONObject json = (JSONObject) arr.get(i);
               hash.put(json.getString(id), json);
           }
           //遍历结果集
           for (int j = 0; j < arr.size(); j++) {
               //单条记录
               JSONObject aVal = (JSONObject) arr.get(j);
               //在hash中取出key为单条记录中pid的值
               JSONObject hashVP = (JSONObject) hash.get(aVal.get(pid).toString());
               //如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
               if (hashVP != null) {
                   //检查是否有child属性
                   System.out.println("======child:"+hashVP.get(child));
                   if (hashVP.get(child) != null && ""!=hashVP.get(child) && !"".equalsIgnoreCase(hashVP.get(child).toString())) {
                       JSONArray ch = (JSONArray) hashVP.get(child);
                       ch.add(aVal);
                       hashVP.put(child, ch);
                   } else {
                       JSONArray ch = new JSONArray();
                       ch.add(aVal);
                       hashVP.put(child, ch);
                   }
               } else {
                   r.add(aVal);
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return r;
    }
}
