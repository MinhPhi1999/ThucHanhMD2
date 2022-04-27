package com.codegym.model;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private String telephoneNumber;
    private String group;
    private String name;
    private String sex;
    private String address;
    private String birthday;
    private String email;

    public DanhBa() {
    }

    public DanhBa( String telephoneNumber, String group, String name, String sex, String address, String birthday, String email) {
        this.telephoneNumber = telephoneNumber;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }


    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                ", telephoneNumber=" + telephoneNumber +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}'+"\n";
    }
}
