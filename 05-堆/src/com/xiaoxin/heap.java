package com.xiaoxin;


public interface heap<E> {
    int size();//元素数量
    boolean isEmpty();//是否为空
    void clean();//清空
    void add(E element);//添加元素
    E get();//获得堆顶元素
    E remove();//删除堆顶元素
    E replace(E element);//替换堆顶元素
}
