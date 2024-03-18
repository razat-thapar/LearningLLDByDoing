package com.lld.one.n_serialization.g_effect_of_inheritance.b_super_dont_implements_serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Manager extends Employee implements Serializable{
    private ManagerLevel managerLevel;
    @Serial
    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        //serialize employee attributes.
        validate();
        stream.writeInt(id);
        stream.writeUTF(name);
        stream.writeUTF(email);
        stream.writeDouble(salary);
        stream.writeInt(managerId);
        //serialize manager attributes.
        stream.defaultWriteObject();
    }
    @Serial
    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
        //deserialize employee attributes.
        this.id = stream.readInt();
        this.name = stream.readUTF();
        this.email = stream.readUTF();
        this.salary= stream.readDouble();
        this.managerId = stream.readInt();
        //deserialize manager attributes.
        stream.defaultReadObject();

    }

    public void validate() throws InvalidObjectException {
        //check if object attributes are non-null then only perform serialization.
        if(id==null || name==null || email ==null || managerId==null || salary ==null){
            throw new InvalidObjectException("attributes can't be null!");
        }
    }
}
