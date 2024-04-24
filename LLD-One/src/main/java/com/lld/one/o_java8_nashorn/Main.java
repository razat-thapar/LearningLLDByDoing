package com.lld.one.o_java8_nashorn;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //Please note it's works only with Java 8 as it's not a freeware in Java 17 or it's not open source.
        ScriptEngineManager mgr = new ScriptEngineManager();

        ScriptEngine engine = mgr.getEngineByName("nashorn");
        //ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            //executing javascript.
            engine.eval("print('Hello')");
            //invoking javascript functions from a separate file.
            engine.eval(new FileReader("functions.js"));
            Invocable inv = (Invocable) engine;
            inv.invokeFunction("abc");
            inv.invokeFunction("add",1,2);
            String name = (String)inv.invokeFunction("greet","Wissen Technologies");

        } catch (ScriptException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
