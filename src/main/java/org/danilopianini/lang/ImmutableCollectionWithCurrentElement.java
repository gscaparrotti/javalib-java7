/*******************************************************************************
 * Copyright (C) 2009, 2015, Danilo Pianini and contributors
 * listed in the project's build.gradle or pom.xml file.
 *
 * This file is distributed under the terms of the Apache License, version 2.0
 *******************************************************************************/
package org.danilopianini.lang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <E>
 */
public class ImmutableCollectionWithCurrentElement<E> implements CollectionWithCurrentElement<E>, Serializable {

    private static final long serialVersionUID = 1L;
    private final Collection<E> col;
    private E cur;

    /**
     * @param origin
     *            the collection to make immutable and with a "current" element
     * @param current
     *            the current element
     */
    public ImmutableCollectionWithCurrentElement(final Collection<E> origin, final E current) {
        col = Collections.unmodifiableCollection(new ArrayList<>(origin));
        setCurrent(current);
    }

    @Override
    public boolean add(final E arg0) {
        return col.add(arg0);
    }

    @Override
    public boolean addAll(final Collection<? extends E> arg0) {
        return col.addAll(arg0);
    }

    @Override
    public void clear() {
        col.clear();
    }

    @Override
    public boolean contains(final Object arg0) {
        return col.contains(arg0);
    }

    @Override
    public boolean containsAll(final Collection<?> arg0) {
        return col.containsAll(arg0);
    }

    @Override
    public boolean isEmpty() {
        return col.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return col.iterator();
    }

    @Override
    public boolean remove(final Object arg0) {
        return col.remove(arg0);
    }

    @Override
    public boolean removeAll(final Collection<?> arg0) {
        return col.removeAll(arg0);
    }

    @Override
    public boolean retainAll(final Collection<?> arg0) {
        return col.retainAll(arg0);
    }

    @Override
    public int size() {
        return col.size();
    }

    @Override
    public Object[] toArray() {
        return col.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] arg0) {
        return col.toArray(arg0);
    }

    @Override
    public E getCurrent() {
        return cur;
    }

    @Override
    public final void setCurrent(final E e) {
        if (col.contains(e)) {
            cur = e;
        } else {
            throw new NoSuchElementException();
        }
    }

}
