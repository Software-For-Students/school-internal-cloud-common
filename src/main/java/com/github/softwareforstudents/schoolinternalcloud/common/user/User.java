package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.util.Set;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;

public class User {

    private String username;
    private UserDetails userDetails;
    private Set<Permission> permissions;
    private Set<Group> groups;
    
    public User(@NotNull final String username, @NotNull final UserDetails userDetails, @NotNull final Set<Permission> permissions, @NotNull final Set<Group> groups) {
        this.username = username;
        this.userDetails = userDetails;
        this.permissions = permissions;
        this.groups = groups;
    }

    @Immutable
    public String getUsername() {
        return String.valueOf(username);
    }

    public void setUsername(@NotNull final String username) {
        this.username = username;
    }

    @Immutable
    public UserDetails getUserDetails() {
        return userDetails.clone();
    }

    public void setUserDetails(@NotNull final UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Immutable
    public Set<Permission> getPermissions() {
        return Set.copyOf(permissions);
    }

    public void setPermissions(@NotNull final Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(@NotNull final Permission permission) {
        permissions.add(permission);
    }

    public void removePermission(@NotNull final Permission permission) {
        permissions.remove(permission);
    }

    @Immutable
    public Set<Group> getGroups() {
        return Set.copyOf(groups);
    }

    public void setGroups(@NotNull final Set<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(@NotNull final Group group) {
        groups.add(group);
    }

    public void removeGroup(@NotNull final Group group) {
        groups.remove(group);
    }


}