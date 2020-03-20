package com.github.softwareforstudents.schoolinternalcloud.common.user;

import java.util.Set;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;

public class Group {

    private String name;
    private Set<User> users;

    public Group(@NotNull final String name, @NotNull final Set<User> users) {
        this.name = name;
        this.users = users;
    }

    @Immutable
    public String getName() {
        return String.valueOf(name);
    }

    public void setName(@NotNull final String name) {
        this.name = name;
    }

    @Immutable
    public Set<User> getUsers() {
        return Set.copyOf(users);
    }

    public void setUsers(@NotNull final Set<User> users) {
        this.users = users;
    }

    public void addUser(@NotNull final User user) {
        users.add(user);
    }

    public void removeUser(@NotNull final User user) {
        users.remove(user);
    }
}