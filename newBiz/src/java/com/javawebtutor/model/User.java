
package com.javawebtutor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER_TABLE")
public class User implements Serializable {
    
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String email;
    private String userId;
    private String password;
    private String address;
    private Long aadhar;
    private String sponseId;
    private Integer addedUsers;
    private Integer Earnings;
    public User() {
    }

    
    public User(String firstName, String middleName, String lastName,String fatherName,String motherName ,String email, String userId, String password,String address,Long aadhar,Integer addedUsers,String registerId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.address=address;
       
        this.aadhar=aadhar;
        this.addedUsers=addedUsers;
        this.sponseId=registerId;
        this.Earnings=0;
    }


    public Long getId() {
        return id;
    }

     public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
    
    
    public Long getaadhar() {
        return aadhar;
    }

    public void setaadhar(Long aadhar) {
        this.aadhar = aadhar;
    }
     public Integer getaddedUsers() {
        return addedUsers;
    }

    public void setaddedUsers(Integer addedUsers) {
        this.addedUsers = addedUsers;
    }

    public String getRegisterId() {
        return sponseId;
    }

    public void setRegisterId(String registerId) {
        this.sponseId = registerId;
    }

    public Integer getEarnings() {
        return Earnings;
    }

    public void setEarnings(Integer Earnings) {
        this.Earnings = Earnings;
    }

    
    
}
