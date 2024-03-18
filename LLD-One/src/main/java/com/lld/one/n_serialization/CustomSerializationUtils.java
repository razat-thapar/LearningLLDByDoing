package com.lld.one.n_serialization;

import com.lld.one.n_serialization.e_custom_serialization_using_externalization.User;

import java.io.*;

public class CustomSerializationUtils {
    public void serialize(Externalizable obj, String filename) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            //convert to byte stream and write it to output stream
            obj.writeExternal(oos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
            fos.close();
        }
    }
    public User deserializeUser(String filename) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        //get the byte stream from filename.
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            User user = User.builder().build();
            user.readExternal(ois);
            return user;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            ois.close();
            fis.close();
        }
        return null;
    }
}
