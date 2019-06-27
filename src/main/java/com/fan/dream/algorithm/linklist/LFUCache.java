package com.fan.dream.algorithm.linklist;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    int size = 0;
    int cap = 0;
    Map<Integer, DListNode> map = new HashMap<>();
    DListNode head = null, tail = null;

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity (缓存容量) */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node == head) {
            return node.val;
        }
        DListNode prev = node.prev;
        if (node == tail) {
            tail = prev;
        }
        DListNode nextNode = node.next;
        if (prev != null) {
            prev.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;

        return node.val;
    }

    public void put(int key, int value) {
        if (size == cap) {
            //移除最后一个
            DListNode prev = tail.prev;
            map.put(tail.key, null);
            prev.next = null;
            tail.prev = null;
            tail = prev;
        } else {
            size++;
        }
        DListNode node = new DListNode(key, value);
        map.put(key, node);
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        if (tail == null) {
            tail = head;
        }
        head = node;

    }

    class DListNode {

        int key;
        int val;
        DListNode prev;
        DListNode next;

        DListNode(int y, int x) {
            key = y;
            val = x;
        }
    }
}
