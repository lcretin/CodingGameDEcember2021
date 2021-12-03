package com.codinggame.decembre;

public class Logger {

    private boolean logActivasted = true;

    public void println(String log){
        if(logActivasted){
            System.err.println(log);
        }
    }
}
