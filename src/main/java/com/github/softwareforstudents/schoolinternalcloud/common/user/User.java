package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.util.Set;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;

public class User {

    private String username;
    private UserDetails userDetails;
    private Set<Permission> permissions;
    private Set<Group> groups;
    
    public User(@NotNull String username, @NotNull UserDetails userDetails, @NotNull Set<Permission> permissions, @NotNull Set<Group> groups) {
        this.username = username;
        this.userDetails = userDetails;
        this.permissions = permissions;
        this.groups = groups;
    }

    @Immutable
    public String getUsername() {
        return String.valueOf(username);
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @Immutable
    public UserDetails getUserDetails() {
        return userDetails.clone();
    }

    public void setUserDetails(@NotNull UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Immutable
    public Set<Permission> getPermissions() {
        return Set.copyOf(permissions);
    }

    public void setPermissions(@NotNull Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(@NotNull Permission permission) {
        permissions.add(permission);
    }

    public void removePermission(@NotNull Permission permission) {
        permissions.remove(permission);
    }

    @Immutable
    public Set<Group> getGroups() {
        return Set.copyOf(groups);
    }

    public void setGroups(@NotNull Set<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(@NotNull Group group) {
        groups.add(group);
    }

    public void removeGroup(@NotNull Group group) {
        groups.remove(group);
    }


}