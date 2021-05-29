package com.tms.Homework_12_TMS.Homework_12_TMS_ex1;

public interface IMYCustomArray<E> {

    public boolean add(E elem);
    public E get (int index);
    public boolean remove(int index);
    public boolean contains(Object elem);
    public boolean removeCollection();
    public int size();
    public void resize(int newLength);
    public void add(int index, E elem);
}
