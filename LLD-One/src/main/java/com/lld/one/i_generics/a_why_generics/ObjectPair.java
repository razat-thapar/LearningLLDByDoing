package com.lld.one.i_generics.a_why_generics;

import java.util.Objects;

public class ObjectPair {
    Object a ;
    Object b ;
    public ObjectPair(Object a, Object b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "ObjectPair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectPair that = (ObjectPair) o;

        if (!Objects.equals(a, that.a)) return false;
        return Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }
}
