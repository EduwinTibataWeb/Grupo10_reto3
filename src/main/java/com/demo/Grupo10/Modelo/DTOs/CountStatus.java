/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Modelo.DTOs;

/**
 *
 * @author Diseño Compass
 */
public class CountStatus {
    private long completed;
    private long cancelled;

    public CountStatus(long completed, long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    public long getCancelled() {
        return cancelled;
    }

    public void setCancelled(long cancelled) {
        this.cancelled = cancelled;
    }
    
}
