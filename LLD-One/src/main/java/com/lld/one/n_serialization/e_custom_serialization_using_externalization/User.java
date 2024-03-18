package com.lld.one.n_serialization.e_custom_serialization_using_externalization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Getter
@Setter
@Builder
@ToString
public class User implements Externalizable {
    private static final long serialVersionUID = 1000L;
    @ToString.Include
    private static String species = "HUMAN";
    private int id;
    private String name;
    private String email;
    private String password;
    private static String key = "#abc";
    public String encrypt(String password) {
        return key+password;
    }
    public String decrypt(String input){
        validate(input);
        return input.substring(key.length());
    }
    public static void validate(String input){
        if(!input.substring(0,key.length()).equals(key)){
            throw new RuntimeException("Corrupted data ! ");
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeUTF(email);
        //perform encyrption of password.
        out.writeUTF(encrypt(password));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //we need to deserialize in the exact same order of serialization.
        this.id = in.readInt();
        //System.out.printf("id: %d, name: %s, email: %s, pass: %s%n",id,name,email,password);
        this.name = in.readUTF();
        this.email = in.readUTF();
        this.password = in.readUTF();
        //decrypt the password
        this.password = decrypt(this.password);

    }
}
