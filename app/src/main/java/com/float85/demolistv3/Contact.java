package com.float85.demolistv3;

public class Contact {
    String name;
    String phoneNumber;
    boolean icon;

    public Contact(String name, String phoneNumber, boolean icon) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isIcon() {
        return icon;
    }

    public void setIcon(boolean icon) {
        this.icon = icon;
    }
}
