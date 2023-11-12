package com.example.lab3_mob403.modal;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public class contacts {
    private String id;
    private String name;
    private String email;
    private String address;
    private String gender;
    private String profile_pic;
    private Phone phone;

    public contacts() {
    }

    public contacts(String id, String name, String email, String address, String gender, String profile_pic, Phone phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.profile_pic = profile_pic;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    public class Phone {
        private String mobile;
        private String home;
        private String office;

        // Các getter và setter

        public Phone(String mobile, String home, String office) {
            this.mobile = mobile;
            this.home = home;
            this.office = office;
        }

        public Phone() {
        }

        public String getMobile() {
            return mobile;
        }

        public String getHome() {
            return home;
        }

        public String getOffice() {
            return office;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public void setOffice(String office) {
            this.office = office;
        }
    }
}
