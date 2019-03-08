package com.kali.kali.Idea;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PersonDTO  implements Serializable {
    private String paidPerson,Description;

    private Map<String,Double> contributedList;
    private double totalMoney;
    private double perHeadMoney;
    private int count;

    public String getPaidPerson() {
        return paidPerson;
    }

    public void setPaidPerson(String paidPerson) {
        this.paidPerson = paidPerson;
    }

    public Map<String, Double> getContributedList() {
        return contributedList;
    }

    public void setContributedList(Map<String, Double> contributedList) {
        this.contributedList = contributedList;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getPerHeadMoney() {
        return perHeadMoney;
    }

    public void setPerHeadMoney(double perHeadMoney) {
        this.perHeadMoney = perHeadMoney;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
