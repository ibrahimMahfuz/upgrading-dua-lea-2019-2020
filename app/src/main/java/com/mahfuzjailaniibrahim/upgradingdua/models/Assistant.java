package com.mahfuzjailaniibrahim.upgradingdua.models;

public class Assistant {
    private String name;
    private String address;
    private String noAssistant;

    public Assistant(String name, String address, String noAssistant) {
        this.name = name;
        this.address = address;
        this.noAssistant = noAssistant;
    }

    public Assistant(){} //Firebase Require

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoAssistant() {
        return noAssistant;
    }

    public void setNoAssistant(String noAssistant) {
        this.noAssistant = noAssistant;
    }
}
