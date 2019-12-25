package com.cheelou.base.temp;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author
 * 将map转换成字符串，格式如"key1:value;key2:value2"
 * @createTime 2019/6/24 11:50
 */
public class Map2Str {
    public static void main(String[] args) {
        AbstractClazz zz = new AbstractClazz() {
            @Override
            public void asMethod() {

            }
        };

        String s = null;//结果字符串
        synchronized (s) {
            s = null;
        }

        Map<String,Object> map = new HashMap();
        map.put("key1","value");
        map.put("key2","value2");
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        if(!ObjectUtils.isEmpty(entrySet)){
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : entrySet){
                sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
            }
            s = sb.toString();
        }

        System.out.println(s);

/*
        // preserve order 保持原序 避免多线程链表环get死循环
        HashMap.Node<K,V> loHead = null, loTail = null;
        HashMap.Node<K,V> hiHead = null, hiTail = null;
        HashMap.Node<K,V> next;
        do {
            next = e.next;
            if ((e.hash & oldCap) == 0) {
                //尾部初始化值为null,故第一次循环完新链表头部为e，第二个元素（此时的尾部）也为e
                if (loTail == null)
                    loHead = e;
                else
                    loTail.next = e;
                loTail = e;
            }
            else {
                if (hiTail == null)
                    hiHead = e;
                else
                    hiTail.next = e;
                hiTail = e;
            }
        } while ((e = next) != null);
        if (loTail != null) {
            loTail.next = null;
            newTab[j] = loHead;
        }
        if (hiTail != null) {
            hiTail.next = null;
            newTab[j + oldCap] = hiHead;
        }*/
    }


}
