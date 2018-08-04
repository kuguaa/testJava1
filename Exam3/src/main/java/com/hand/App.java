package com.hand;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 获得 List
        List<Integer> lists= new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i <50; i++) {
            lists.add(random.nextInt(100));
        }
        System.out.println( "随机生成50个小于100的数，分别为："+lists );

        // List 生成 Map
        Map<Integer,List> map=new HashMap<>();
        Iterator<Integer> iter=lists.iterator();
        while (iter.hasNext()){
            map.put(iter.next()/10,null);
        }
        Set<Integer> s=map.keySet();
        Iterator<Integer> iter2=s.iterator();
        while (iter2.hasNext()){
            List<Integer> list2=new ArrayList<>();
            Iterator<Integer> iter3=lists.iterator();
            while (iter3.hasNext()){
                if((iter3.next()/10)==iter2.next()){
                    list2.add(iter3.next());
                }
            }
            map.put(iter2.next(),list2);
        }

        // 输出 Map
        System.out.print( "Map中的数据为: {" );
        while (iter2.hasNext()){
            System.out.print(iter2.next()+"=>"+map.get(iter2.next())+",");
        }
        System.out.print( "}" );
    }
}
