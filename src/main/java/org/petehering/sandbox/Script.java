package org.petehering.sandbox;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Script
{
    private final String function;
    private final ScriptEngine engine;
    
    public Script(String file, String function) throws URISyntaxException, IOException, ScriptException
    {
        this.function = function;
        
        Class c = getClass();
        URL url = c.getResource(file);
        URI uri = url.toURI();
        Path path = Paths.get(uri);
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes);
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByExtension("js");
        Object result = engine.eval(content);
    }
    
    public Object invoke(Object ... args) throws ScriptException, NoSuchMethodException
    {
        return ((Invocable)engine).invokeFunction(function, args);
    }
}
