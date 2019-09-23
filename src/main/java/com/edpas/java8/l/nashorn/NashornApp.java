package com.edpas.java8.l.nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornApp {

	private ScriptEngineManager manager;
	private ScriptEngine engine; 
	private Invocable invoker;
	
	
	public NashornApp() {
		this.manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName("nashorn");
		this.invoker = (Invocable)engine;
	}
	
	private void useFunctions() throws Exception {
		this.engine.eval("print('javascript from Java')");
		System.out.println();
		
		this.engine.eval(new FileReader("src/main/java/com/edpas/java8/l/nashorn/file.js"));
		String result1 = (String)this.invoker.invokeFunction("calculate", "2", "3");
		System.out.println("Result 1: "+result1);		
		
		double result2 = (double)this.invoker.invokeFunction("calculate", 2, 3);
		System.out.println("Result 2: "+result2);
	}
	
	private void useInterface() throws Exception {
		System.out.println();
		
		this.engine.eval(new FileReader("src/main/java/com/edpas/java8/l/nashorn/file.js"));
		
		Object implementation = this.engine.get("threadImpl");
		Runnable runnable = this.invoker.getInterface(implementation, Runnable.class);
		
		Thread thread1 = new Thread(runnable);
		thread1.start();
		
		Thread thread2 = new Thread(runnable);
		thread2.start();
	}
	
	public static void main(String[] args) throws Exception {
		NashornApp app = new NashornApp();
		
		app.useFunctions();
		
		app.useInterface();
	}
}
