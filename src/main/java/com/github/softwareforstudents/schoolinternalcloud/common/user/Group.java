package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.util.Set;

public class Group {

    private String name;
    private Set<User> users;

    public Group(final String name, final Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    public void addUser(final User user) {
        users.add(user);
    }

    public void removeUser(final User user) {
        users.remove(user);
    }
}