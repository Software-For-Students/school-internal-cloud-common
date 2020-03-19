package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.util.Set;

public class User {

    private String username;
    private UserDetails userDetails;
    private Set<Permission> permissions;
    private Set<Group> groups;
    
    public User(final String username, final UserDetails userDetails, final Set<Permission> permissions, final Set<Group> groups) {
        this.username = username;
        this.userDetails = userDetails;
        this.permissions = permissions;
        this.groups = groups;
    }

    public String getUsername() {
        return String.valueOf(username);
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public UserDetails getUserDetails() {
        return userDetails.clone();
    }

    public void setUserDetails(final UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Set<Permission> getPermissions() {
        return Set.copyOf(permissions);
    }

    public void setPermissions(final Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(final Permission permission) {
        permissions.add(permission);
    }

    public void removePermission(final Permission permission) {
        permissions.remove(permission);
    }

    public Set<Group> getGroups() {
        return Set.copyOf(groups);
    }

    public void setGroups(final Set<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(final Group group) {
        groups.add(group);
    }

    public void removeGroup(final Group group) {
        groups.remove(group);
    }


}