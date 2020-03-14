package com.github.softwareforstudents.schoolinternalcloud.common.user;

public interface Permission {

    public String getPermissionName();

    @Override
    boolean equals(Object obj);

}