package org.yitzi.video.api.apivideo.infrastructure.pagination;

import java.util.Iterator;

public class IteratorIterable<T> implements Iterable<T> {
    private Iterator<T> iterator;

    public IteratorIterable(PageIterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return iterator;
    }
}