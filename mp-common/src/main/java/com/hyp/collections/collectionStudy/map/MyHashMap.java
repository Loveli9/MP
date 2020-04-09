package com.hyp.collections.collectionStudy.map;

/**
 * 手写HashMap实现类
 * */
public class MyHashMap<K,V> {

    private Entry[] table;
    private static final Integer CAPACITY = 8;
    private Integer size = 0;

    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public int size() {
        return size;
    }
    public Object get(Object k) {
        int hashCode = k.hashCode();
//        int index = hashCode % 8;
        int index = hashCode & (CAPACITY - 1);//与上面等价
        for(Entry<K,V> entry = table[index];entry != null;entry = entry.next) {//遍历链表
            if(entry.k.equals(k)) {
                return entry.v;
            }
        }
        return null;
    }
    public Object put(K k,V v) {
        int hashCode = k.hashCode();
//        int index = hashCode % 8;
        int index = hashCode & (CAPACITY - 1);//与上面等价
        for(Entry<K,V> entry = table[index];entry != null;entry = entry.next) {
            if(entry.k.equals(k)) {
                V oldValue = entry.v;
                entry.v = v;
                return oldValue;
            }
        }
        //增加节点
        this.addEntry(k, v, index);
        return null;
    }

    private void addEntry(K k, V v, int index) {
        //增加节点
        Entry entry = new Entry(k,v,table[index]);
        table[index] = entry;
        size++;
    }

    static class Entry<K,V> {
        private K k;
        private V v;
        private Entry<K,V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        for(int i=0;i<10;i++) {
            myHashMap.put("周瑜" + i,"老师" + i);
        }
        System.out.println(myHashMap.get("周瑜1"));
    }

}
