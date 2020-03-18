package com.github.softwareforstudents.schoolinternalcloud.common.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

import com.github.softwareforstudents.schoolinternalcloud.common.annotations.Immutable;
import com.github.softwareforstudents.schoolinternalcloud.common.annotations.NotNull;
import com.sun.net.httpserver.HttpServer;

class Webservice implements AutoCloseable {

    private final static int DEFAULT_TCP_CONNECTION_BACKLOG = -1;
    private final static int SERVER_STOP_WAIT_DELAY = 10;

    private HttpServer httpServer;
    private Set<String> routes;

    public Webservice(int port) {
        this(port, DEFAULT_TCP_CONNECTION_BACKLOG);
    }

    public Webservice(int port, int connectionBacklog) {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), connectionBacklog);
            routes = new HashSet<>();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void start() {
        httpServer.start();
    }

    public void close() {
        httpServer.stop(SERVER_STOP_WAIT_DELAY);
    }

    public boolean registerRoute(@NotNull String path, @NotNull RouteHandler handler) {
        try {
            httpServer.createContext(path, handler);
            routes.add(path);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public boolean unregisterRoute(@NotNull String path) {
        try {
            httpServer.removeContext(path);
            routes.remove(path);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    @Immutable
    public Set<String> getAllRoutes() {
        return Set.copyOf(routes);
    }

}