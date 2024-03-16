package com.lld.one.n_serialization;

import java.io.*;

public class SerializationUtils<E> {
    //convert a java object to byte stream and save it to a file.
    public void serialize(E obj, String filename) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            //convert to byte stream and write it to output stream
            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            oos.close();
            fos.close();
        }
    }

    //convert the byte stream representation of an object stored in file to it's Java Object!.
    public E deserialize(String filename) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        //get the byte stream from filename.
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            return (E) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            ois.close();
            fis.close();
        }
        return null;
    }
}
