package com.company;

public class MyHashMap <K,V> {

    private Entry[] tables;
    private static Integer CAPACITY = 8;
    private int size = 0;

    public MyHashMap(){
        this.tables = new Entry[CAPACITY];
    }

    public int size() {
        return size;
    }
    public Object get(Object key) {
        int hash = key.hashCode();
        int i = hash%8;

        for(Entry<K,V> entry=tables[i];entry!=null;entry=entry.next){
            if(entry.k.equals(key)){
                return entry.v;
            }
        }
        return null;
    }
    public Object put(K key, V value) {

        int hash = key.hashCode();
        int i = hash%8;

        for(Entry<K,V> entry=tables[i];entry!=null;entry=entry.next){
            if(entry.k.equals(key)){
                V oldValue = entry.v;
                entry.v=value;
                return oldValue;
            }
        }
        addEntry(key, value, i);
        return null;
    }

    private void addEntry(K key, V value, int i) {
        //增加节点
        Entry entry = new Entry(key,value,tables[i]);
        tables[i] = entry;
        size++;
    }
    class Entry<K,V>{
        private Entry<K,V> next;
        private K k;
        private V v;
        public Entry(K k,V v,Entry<K,V> next){
            this.k=k;
            this.v=v;
            this.next=next;
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
        MyHashMap<String,String> hashMap = new MyHashMap<>();
        for(int i=0;i<10;i++){
            hashMap.put("周瑜"+i,"xx"+i);
        }
        System.out.println(hashMap.get("周瑜1"));
    }
}

