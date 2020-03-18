package com.github.softwareforstudents.schoolinternalcloud.common.web.shared;

import java.io.IOException;

import com.github.softwareforstudents.schoolinternalcloud.common.web.HttpMethods;
import com.github.softwareforstudents.schoolinternalcloud.common.web.HttpStatusCodes;
import com.github.softwareforstudents.schoolinternalcloud.common.web.RouteHandler;
import com.sun.net.httpserver.HttpExchange;

public class HeartbeatRoute implements RouteHandler {

    @Override
    public void handle(HttpExchange exchange) {
        try {
            if (!exchange.getRequestMethod().equals(HttpMethods.GET.toString())) {
                exchange.sendResponseHeaders(HttpStatusCodes.METHOD_NOT_ALLOWED.getStatusCode(), 0);
                throw new Exception();
            }
            exchange.sendResponseHeaders(HttpStatusCodes.OK.getStatusCode(), 0);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            //just thrown to reach finally block
        } finally {
            exchange.close();
        }
    }
}