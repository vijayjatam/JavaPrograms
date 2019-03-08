package com.kali.kali.innovate;

import java.io.Serializable;

public class DTOClass implements Serializable {
    private String userName;
    private String password;
    private String morseCode;
    private String pattern;
    private String connetedDevice;

    public String getConnetedDevice() {
        return connetedDevice;
    }

    public void setConnetedDevice(String connetedDevice) {
        this.connetedDevice = connetedDevice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMorseCode() {
        return morseCode;
    }

    public void setMorseCode(String morseCode) {
        this.morseCode = morseCode;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DTOClass){
            DTOClass dtoObj = (DTOClass)obj;
            return this.getUserName().equalsIgnoreCase(dtoObj.getUserName())&& this.getPassword().equalsIgnoreCase(dtoObj.getPassword());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return (this.getUserName().hashCode() + this.getPassword().hashCode()) * 4;
    }
}
