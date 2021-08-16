package com.company;

public class FileDetails {

    private String first, second , third;
    private  SuspiciousLevel suspiciousLevel;

    public FileDetails(String first,String second, String third , SuspiciousLevel suspiciousLevel)
    {
        this.first = first;
        this.second = second;
        this.third = third;
        this.suspiciousLevel = suspiciousLevel;
    }


    public String getFirst() {
        return first;
    }
    public String getSecond() {
        return second;
    }
    public String getThird() {
        return third;
    }
    public SuspiciousLevel getSuspiciousLevel() {
        return suspiciousLevel;
    }

    public void setFirst(String str) {
        first = str;
    }
    public void setSecond(String str) {
        second = str;
    }
    public void setThird(String str) {
        third = str;
    }
    public void setSuspiciousLevel(SuspiciousLevel suspiciousLevel) {
        this.suspiciousLevel = suspiciousLevel;
    }
}
