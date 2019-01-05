package org.petehering.sandbox;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Script script = new Script("/sandbox.js", "execute");
        
        Model model = new Model();
        model.setTitle("Dungeon");
        model.setAuthor("John Doe");
        
        String[] argv = {"take", "key"};
        
        List<String> response = new ArrayList<String>();
        
        script.invoke(new Object[]{model, args, response});
        
        for(String line : response)
        {
            System.out.println(line);
        }
    }
}
