package com.lld.one.o_java9_add_ons.a_try_with_resources;

public interface SerializationUtils<E> {
    public void serialize(E obj);
    public E deserialize();
}
