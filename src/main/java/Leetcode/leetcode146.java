package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode146 {


    class LRUCache {     //LRU (最近最少使用) 缓存
        private int N; //表中初始元素个数
        private  int capacity; //表的容量
        private Map<Integer,DoubleNode> map;

        private DoubleNode start;

        private DoubleNode end;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
            N = 0;
        }

        public int get(int key) {
            DoubleNode res = map.getOrDefault(key,null);
            if(res == null)
                return -1;
            else{
                if(res == start){
                    DoubleNode sup = start.right;
                    end.right = start;
                    start.left = end;
                    start.right = null;
                    end = start;
                    start = sup;
                }
                else if(res != end){
                    DoubleNode sup1 = res.right;
                    DoubleNode sup2 = res.left;
                    sup2.right = sup1;
                    sup1.left = sup2;
                    end.right = res;
                    res.left = end;
                    end= res;
                    end.right = null;
                }
            }
                return res.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                DoubleNode res = map.get(key);
                res.val = value;
                if(res == start){
                    DoubleNode sup = start.right;
                    end.right = start;
                    start.left = end;
                    start.right = null;
                    end = start;
                    start = sup;
                }
                else if(res != end){
                    DoubleNode sup1 = res.right;
                    DoubleNode sup2 = res.left;
                    sup2.right = sup1;
                    sup1.left = sup2;
                    end.right = res;
                    res.left = end;
                    end= res;
                    end.right = null;
                }
            }
            if(N == 0){
                start = new DoubleNode(null,null,key,value);
                end = start;
                map.put(key,start);
                N++;
            }
            else  if(N < capacity){
                DoubleNode node = new DoubleNode(end,null,key,value);
                end.right = node;
                end = node;
                N++;
                map.put(key,node);
            }
            else{
                DoubleNode node = new DoubleNode(end,null,key,value);
                DoubleNode sup = start.right;
                map.remove(start.key);
                map.put(key,node);
                end.right = node;
                end = node;
                sup.left = null;
                start = sup;
            }
        }
    }

    class DoubleNode{
        public DoubleNode left;
        public DoubleNode right;

        public int key;
        public int val;

        public DoubleNode(){
        }

        public DoubleNode(DoubleNode left,DoubleNode right,int key,int val){
            this.left = left;
            this.right = right;
            this.key = key;
            this.val = val;
        }
    }
}
