package GOF.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的聚合类：也就是集合
 */
public class ConcreteMyAggregate {

    private List<Object> list = new ArrayList<Object>();

    public ConcreteMyAggregate() {

    }

    public void addObject(Object object) {
        this.list.add(object);
    }

    public void removeObject(Object object) {
        this.list.remove(object);
    }

    public void setList(List<Object> list) {
        this.list = list;
    }


    //获得迭代器
    public MyIterator createIterator() {
        return new ConcreteIterator();
    }

    /**
     * 内部迭代器
     */
    private class ConcreteIterator implements MyIterator{

        private int cursor;//定义游标，用于记录遍历时的位置

        public ConcreteIterator() {
            first();
        }

        public Object getCurrentObj() {
            return list.get(cursor);
        }

        public void first() {
            cursor = 0;
        }

        public void next() {
            if (hasNext()) {
                cursor++;
            }
        }

        public boolean hasNext() {
            return cursor < list.size();
        }

        public boolean isFirst() {
            return cursor==0;
        }

        public boolean isLast() {
            return cursor==list.size()-1;
        }


    }

}

