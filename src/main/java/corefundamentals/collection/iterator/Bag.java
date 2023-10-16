package corefundamentals.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag<T> implements Iterable<T> {
    private List<T> items;

    public Bag(){
        items = new ArrayList<>();
    }

    public void add(T item){
        items.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator<T>(items);
    }


    private class BagIterator<E> implements Iterator<E>{

        private int indexPosition = 0;
        private List<E> internalList;

        public BagIterator(List<E> internalList) {
            this.internalList = internalList;
        }

        @Override
        public boolean hasNext() {
            return (indexPosition + 1) <= internalList.size();
        }

        @Override
        public E next() {
            E val = internalList.get(indexPosition);
            indexPosition++;
            return val;

        }
    }
}
