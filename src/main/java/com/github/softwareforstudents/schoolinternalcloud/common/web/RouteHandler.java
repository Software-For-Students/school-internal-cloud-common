package com.github.softwareforstudents.schoolinternalcloud.common.web;

import java.io.IOException;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public abstract class RouteHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
        switch (exchange.getRequestMethod()) {
            case "GET":
                handleGet(exchange);
                break;
            case "POST":
                handlePost(exchange);
                break;
            case "PUT":
                handlePut(exchange);
                break;
            case "HEAD":
                handleHead(exchange);
                break;
            case "DELETE":
                handleDelete(exchange);
                break;
            case "PATCH":
                handlePatch(exchange);
                break;
            case "OPTIONS":
                handleOptions(exchange);
                break;
            default:
                defaultHandle(exchange);
                break;
        }

        exchange.close();
    }

    public void handleGet(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    public void handlePost(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    public void handlePut(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    public void handleHead(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    public void handleDelete(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    public void handlePatch(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    public void handleOptions(HttpExchange exchange) {
        defaultHandle(exchange);
    }

    private void defaultHandle(HttpExchange exchange) {
        try {
            exchange.sendResponseHeaders(HttpStatusCodes.METHOD_NOT_ALLOWED.getStatusCode(), -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}