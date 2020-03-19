package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.time.LocalDate;

//TODO stub class -> add details

public class UserDetails implements Cloneable {

    private final LocalDate birthdayDate;

    public UserDetails(final LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Override
    public UserDetails clone() {
        return new UserDetails(birthdayDate);
    }

}