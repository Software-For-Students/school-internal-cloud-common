package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.time.LocalDate;

//TODO stub class -> add details

public class UserDetails implements Cloneable {

    private LocalDate birthdayDate;

    public UserDetails(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Override
    public UserDetails clone() {
        return new UserDetails(birthdayDate);
    }

}