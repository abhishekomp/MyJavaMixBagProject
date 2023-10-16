package corefundamentals.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BagV2<T> implements Iterable<T> {
    private List<T> items;

    public BagV2(){
        items = new ArrayList<>();
    }

    public void add(T item){
        items.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int indexPosition = 0;
            //private List<T> internalList;

//            public BagIterator(List<E> internalList) {
//                this.internalList = internalList;
//            }

            @Override
            public boolean hasNext() {
                return (indexPosition + 1) <= items.size();
            }

            @Override
            public T next() {
                T val = items.get(indexPosition);
                indexPosition++;
                return val;

            }
        };
    }


//    public class BagIterator<E> implements Iterator<E>{
//
//        private int indexPosition = 0;
//        private List<E> internalList;
//
//        public BagIterator(List<E> internalList) {
//            this.internalList = internalList;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return (indexPosition + 1) <= internalList.size();
//        }
//
//        @Override
//        public E next() {
//            E val = internalList.get(indexPosition);
//            indexPosition++;
//            return val;
//
//        }
//    }
}
