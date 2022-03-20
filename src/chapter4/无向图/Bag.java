package chapter4.无向图;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author qyyzxty@icloud.com
 * @data 2022/2/25
 **/
public class Bag<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }

    public void add(Item item) {}

    public boolean isEmpty() { return false; }

    public int size() { return 0; }
}
