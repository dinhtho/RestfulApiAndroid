package com.example.pcpv.restfulapi;

import java.io.Serializable;

/**
 * Created by PCPV on 02/02/2018.
 */

public class SerializedObjectDemo implements Serializable {
    private String name;

    public SerializedObjectDemo(String name, String old) {
        this.name = name;
        this.old = old;
    }

    private String old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }
}
