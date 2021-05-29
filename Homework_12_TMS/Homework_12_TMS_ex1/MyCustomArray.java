package com.tms.Homework_12_TMS.Homework_12_TMS_ex1;

import java.util.Iterator;

public class MyCustomArray<E> implements IMYCustomArray,Iterable<E> {
        public int CONSTANT_ARRAY_SIZE=10;
        private int currentIndex = -1;
        private int pointer=0;
        Object[] initArray = new Object[CONSTANT_ARRAY_SIZE];
        //Метод необходимый для получения колличества элементов массива.
        @Override
        public int size () {
            return pointer;
        }
        //Метод необходимый для добавления эллемента.
        @Override
        public  boolean add(Object elem){
            if(pointer == initArray.length-1)
                resize(initArray.length*3/2+1);
            initArray[pointer++] = elem;
            return true;
        }
        //Метод необходимый для получения элемента по индексу.
        @Override
        public Object get ( int index){
            return initArray[index];
        }
        //Метод необходимый для удаления элемента по индексу.
        @Override
        public boolean remove ( int index){
        boolean rez=false;
            if (index>=0) {
                for (int i = index; i < pointer; i++)
                    initArray[i] = initArray[i + 1];//Смещает элемент который необходимо удалить в самый конец.
                initArray[pointer] = null;//Удаляет элемент.
                pointer--;//Уменьшает размер массива на 1.
                rez=true;
            }
            return rez;
        }
        //Медод необходимый проверки: находится ли данный элемент в коллекции.
        @Override
        public boolean contains (Object elem){
            boolean rez = false;
            for (Object item: initArray) {
                if (elem.equals(item)) {
                    rez = true;
                }
            }
            return rez;
        }
        //Для удаления всей элементов коллекции.
        @Override
        public boolean removeCollection () {
            Object[] newArray = new Object[CONSTANT_ARRAY_SIZE];
            initArray = newArray;
            return false;
        }
        //Вспомогательный метод для автаматического увеличения массива.
        @Override
        public void resize (int newLength) {
            Object[] newArray = new Object[newLength];
            System.arraycopy(initArray, 0, newArray, 0, CONSTANT_ARRAY_SIZE);
            initArray = newArray;
        }
        //Метод необходимый для добавления элемента в любую часть массива.
        @Override
         public void add(int index, Object elem) {
        Object[] newArray = new Object[pointer+1];
        System.arraycopy(initArray, 0, newArray, 0, index);
        System.arraycopy(initArray, index, newArray, index+1, pointer-index);
        initArray=newArray;
        initArray[index]=elem;
        pointer++;
    }
        @Override
        public Iterator<E> iterator () {
        return new OwnIterator<>();
    }

    private class OwnIterator<E> implements Iterator<E> {
        private int index = 0;
        private OwnIterator() {
        }
        @Override
        public boolean hasNext() {
            return index < pointer;
        }
        @Override
        public E next() {
            return (E) initArray[index++];
        }
    }
}