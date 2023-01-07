package com.algorithm._10tenAlgorithm._5greedy;

import java.util.*;

//贪心算法
public class GreedyAlgorithm {

    public static void main(String[] args) {
        GreedyAlgorithm ga = new GreedyAlgorithm();

        //创建广播电台,放入到Map中
        Map<String, Set<String>> broadcasts = new HashMap<String, Set<String>>();
        //将各个电台放入broadcasts
        Set<String> set1 = new HashSet<String>();
        set1.add("杭州");
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        Set<String> set2 = new HashSet<String>();
        set2.add("广州");
        set2.add("北京");
        set2.add("上海");
        set2.add("天津");

        Set<String> set3 = new HashSet<String>();
        set3.add("成都");
        set3.add("武汉");
        set3.add("杭州");

        Set<String> set4 = new HashSet<String>();
        set4.add("上海");
        set4.add("天津");

        Set<String> set5 = new HashSet<String>();
        set5.add("广州");
        set5.add("杭州");
        set5.add("大连");

        //加入到map中
        broadcasts.put("K1", set1);
        broadcasts.put("K2", set2);
        broadcasts.put("K3", set3);
        broadcasts.put("K4", set4);
        broadcasts.put("K5", set5);

        List<String> selects = ga.greedy(broadcasts);

        System.out.println(selects);

    }

    /**
     * @param broadcasts 输入进来的电台信息列表
     * @return
     */
    public List<String> greedy(Map<String, Set<String>> broadcasts) {

        //遍历存储所有地区到allAreas中
        Set<String> allAreas = new HashSet<String>();
        for (Map.Entry<String, Set<String>> entry : broadcasts.entrySet()) {
            Set<String> area = entry.getValue();
            Iterator<String> itArea = area.iterator();
            while (itArea.hasNext()) {
                allAreas.add(itArea.next());
            }
        }

        System.out.println(allAreas);

        //创建ArrayList集合,用来存放每一轮maxKey所指电台覆盖的地区
        // 当前选择的电台的集合
        List<String> selects = new ArrayList<String>();

        //定义一个临时的集合,在遍历过程中，用来存储遍历过程中当前电台所覆盖地区和当前allAreas集合中所剩的电台覆盖的所有地区的交集
        Set<String> tempSet = new HashSet<String>();

        //定义一个maxKey,用来保存一次遍历过程中,覆盖地区最多的key（占所有地区）
        //如果maxKey不为null,则加入到selects中
        String maxKey = null;

        //定义一个maxKey临时的集合,在遍历过程中,存放遍历过程中电台覆盖的地区和当前还没有覆盖的地区的交集
        Set<String> tempMaxKeySet = new HashSet<String>();

        while (!allAreas.isEmpty()) {//如果allAreas不为空,则表示还没有覆盖到所有地区
            maxKey = null;//每新的一轮开始，都要将maxKey置空
            tempMaxKeySet.clear();//并将存储maxKey的集合清空

            //遍历broadcasts,取出对应的key
            for (String key : broadcasts.keySet()) {
                tempSet.clear();//每一次都需要清空临时集合

                //当前key所能覆盖的地区
                Set<String> area = broadcasts.get(key);

                //加入
                tempSet.addAll(area);

                //求出tempSet和allAreas的交集并赋给tempSet
                tempSet.retainAll(allAreas);// retainAll 求交集

                // 如果当前这个集合包含未覆盖地区的数量比maxKey指向的集合包含未覆盖地区的数量还多
                // 就需要重置maxKey和它指向的集合包含未覆盖地区集合
                // tempSet.size() > tempMaxKeySet.size()体现贪心算法的特点,每次都选择最优的
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > tempMaxKeySet.size())) {
                    //清空,防止数据间影响
                    tempMaxKeySet.clear();

                    maxKey = key;

                    //maxKey覆盖的地区和当前还没有覆盖的地区的交集
                    Set<String> area2 = broadcasts.get(maxKey);//获取当前集合中广播覆盖的城市
                    tempMaxKeySet.addAll(area2);//加入
                    tempMaxKeySet.retainAll(allAreas);//求交集
                    //此时tempMaxKeySet中存放的这就这一轮的maxkey所代表的广播包含的城市
                }
            }

            //maxKey != null,就应该将maxKey加入selects中
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        return selects;
    }

}