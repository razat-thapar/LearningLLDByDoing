package com.lld.two.b_singleton_pattern.g_double_check_locking_serialization_fix;

import java.io.*;

public class SerializationUtils<E> {
    public void serialize(E obj, String filename) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            //perform serialization of obj using writeObject() method.
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            fos.close();
            oos.close();
        }
    }
    public E deserialize(String filename) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            //perform deserialization from ois and return obje.
            return (E) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            fis.close();
            ois.close();
        }
    }
}
