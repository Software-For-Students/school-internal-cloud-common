package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.util.Set;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;

public class Group {

    private String name;
    private Set<User> users;

    public Group(@NotNull String name, @NotNull Set<User> users) {
        this.name = name;
        this.users = users;
    }

    @Immutable
    public String getName() {
        return String.valueOf(name);
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Immutable
    public Set<User> getUsers() {
        return Set.copyOf(users);
    }

    public void setUsers(@NotNull Set<User> users) {
        this.users = users;
    }

    public void addUser(@NotNull User user) {
        users.add(user);
    }

    public void removeUser(@NotNull User user) {
        users.remove(user);
    }
}