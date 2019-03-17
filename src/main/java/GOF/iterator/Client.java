package GOF.iterator;

public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aaa");
        cma.addObject("bbb");
        cma.addObject("ccc");
        MyIterator myIterator = cma.createIterator();
        System.out.println(myIterator.isFirst()+","+myIterator.isLast());
        while (myIterator.hasNext()) {
            System.out.println(myIterator.getCurrentObj());
            myIterator.next();
        }
    }

}
