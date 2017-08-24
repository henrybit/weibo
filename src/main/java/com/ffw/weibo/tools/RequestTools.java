package com.ffw.weibo.tools;

import java.lang.reflect.Field;
import java.util.*;

import com.ffw.weibo.entity.request.AuthorizeRequest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * 请求参数封装工具
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class RequestTools {
    
	public static void main(String[] args) throws Exception {
        AuthorizeRequest request = new AuthorizeRequest();
        request.setClientId("12345dd");
        request.setForcelogin(false);
        request.setDisplay("true");
        request.setLanguage("CN");
        request.setRedirectUri("http://www.sina.com");
        request.setScope("");
        List<NameValuePair> list = getRequestParams(request);
        String json = JSONTools.toJson(list);
        System.out.println(json);
	}

    /**
     * 将对象转化成XML格式数据<br>
     * @param obj 待转化对象
     * @return String
     */
    public static List<NameValuePair> getRequestParams(Object obj) {
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        if (obj != null) {
            Class cls = obj.getClass();
            List<Field> filedList = getAllFields(cls);
            for (int i = 0; filedList != null && i < filedList.size(); i++) {
                Field field = filedList.get(i);
                if (field == null) continue;
                field.setAccessible(true);
                RequestField annotation = field.getAnnotation(RequestField.class);
                String aliasName = field.getName();
                if (annotation != null)
                    aliasName = annotation.name();
                if ("serialVersionUID".equals(aliasName)) continue;
                Class type = field.getType();
                if (type == int.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldInt(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == long.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldLong(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == float.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldFloat(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == double.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldDouble(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == char.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldChar(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == byte.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldByte(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == boolean.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldBoolean(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == short.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldShort(obj, field));
                    paramList.add(nameValuePair);
                } else if (type.isArray()) {
                    //TODO
                } else if (type == Map.class) {
                    HashMap<String, String> map = (HashMap<String, String>)getFieldMap(obj, field);
                    if (map!=null && map.size()>0) {
                        Iterator<String> iterator = map.keySet().iterator();
                        while(iterator.hasNext()) {
                            String key = iterator.next();
                            String value = map.get(key);
                            NameValuePair nameValuePair = new BasicNameValuePair(key,value);
                            paramList.add(nameValuePair);
                        }
                    }
                } else if (type == List.class) {
                    List<Object> list = (List<Object>)obj;
                    for (int j=0; list!=null&&j<list.size(); j++) {
                        Object subObj = list.get(j);
                        if (subObj == null) continue;
                        List<NameValuePair> subList = getRequestParams(subObj);
                        if (subList != null) {
                            paramList.addAll(subList);
                        }
                    }
                } else if (type == String.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, getFieldString(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == Integer.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldInt(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == Long.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldLong(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == Short.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldShort(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == Float.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldFloat(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == Double.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldDouble(obj, field));
                    paramList.add(nameValuePair);
                } else if (type == Character.class) {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldChar(obj, field));
                    paramList.add(nameValuePair);
                } else {
                    NameValuePair nameValuePair = new BasicNameValuePair(aliasName, ""+getFieldString(obj, field));
                    paramList.add(nameValuePair);
                }
            }
        }
        return paramList;
    }

    /**
     * 递归获取所有该类的变量属性<br>
     * @param cls 该类的Class
     * @return List<Field>
     */
    private static List<Field> getAllFields(Class cls) {
        if (cls == null) return null;
        Field[] superFields = cls.getDeclaredFields();
        List<Field> fieldList = new ArrayList<Field>();
        for (int i=0; superFields!=null&&i<superFields.length; i++) {
            Field field = superFields[i];
            if (field == null) continue;
            fieldList.add(field);
        }
        List<Field> superFieldList = getAllFields(cls.getSuperclass());
        if (superFieldList != null)
            fieldList.addAll(superFieldList);
        return fieldList;
    }

    /**
     * Field取Map
     * @param obj
     * @param field
     * @return
     */
    private static Map getFieldMap(Object obj, Field field) {
        try {
            return (Map) field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Field取List<br>
     * @param obj
     * @param field
     * @return
     */
    private static List getFieldList(Object obj, Field field) {
        try {
            return (List)field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Field取Object<br>
     * @param obj
     * @param field
     * @return
     */
    private static Object getFieldObject(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Field取String<br>
     * @param obj
     * @param field
     * @return
     */
    private static String getFieldString(Object obj, Field field) {
        try {
            return (String)field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Field取Int<br>
     * @param obj
     * @param field
     * @return
     */
    private static int getFieldInt(Object obj, Field field) {
        try {
            int value = field.getInt(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Field取Long<br>
     * @param obj
     * @param field
     * @return
     */
    private static long getFieldLong(Object obj, Field field) {
        try {
            long value = field.getLong(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    /**
     * Field取char<br>
     * @param obj
     * @param field
     * @return
     */
    private static char getFieldChar(Object obj, Field field) {
        try {
            char c = field.getChar(obj);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ' ';
    }

    /**
     * Field取byte<br>
     * @param obj
     * @param field
     * @return
     */
    private static byte getFieldByte(Object obj, Field field) {
        try {
            byte b = field.getByte(obj);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Field取Short<br>
     * @param obj
     * @param field
     * @return
     */
    private static short getFieldShort(Object obj, Field field) {
        try {
            short value = field.getShort(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Field取Float<br>
     * @param obj
     * @param field
     * @return
     */
    private static float getFieldFloat(Object obj, Field field) {
        try {
            float value = field.getFloat(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1.0f;
    }

    /**
     * Field取Double<br>
     * @param obj
     * @param field
     * @return
     */
    private static double getFieldDouble(Object obj, Field field) {
        try {
            double value = field.getDouble(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1.0d;
    }

    /**
     * Field取Boolean<br>
     * @param obj
     * @param field
     * @return
     */
    private static boolean getFieldBoolean(Object obj, Field field) {
        try {
            boolean f = field.getBoolean(obj);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
