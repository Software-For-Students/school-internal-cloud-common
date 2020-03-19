package com.github.softwareforstudents.schoolinternalcloud.common.web.shared;

import java.io.IOException;

import com.github.softwareforstudents.schoolinternalcloud.common.web.HttpStatusCodes;
import com.github.softwareforstudents.schoolinternalcloud.common.web.RouteHandler;
import com.sun.net.httpserver.HttpExchange;

public class HeartbeatRoute extends RouteHandler {
    
    @Override
    public void handleGet(final HttpExchange exchange) {
        try {
            exchange.sendResponseHeaders(HttpStatusCodes.OK.getStatusCode(), -1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}