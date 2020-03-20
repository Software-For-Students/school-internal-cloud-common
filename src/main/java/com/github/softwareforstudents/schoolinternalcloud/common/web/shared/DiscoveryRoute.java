package com.github.softwareforstudents.schoolinternalcloud.common.web.shared;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

import com.github.softwareforstudents.schoolinternalcloud.common.web.HttpStatusCodes;
import com.github.softwareforstudents.schoolinternalcloud.common.web.RouteHandler;
import com.sun.net.httpserver.HttpExchange;

public class DiscoveryRoute extends RouteHandler {

    public final static String CONTENT_TYPE = "Content-Type";
    public final static String JSON = "application/json";
    public final static String CHARSET_NAME = "UTF-8";

    private ServiceIdentifier identifier;
    
    public DiscoveryRoute(ServiceIdentifier identifier) {
        this.identifier = identifier;
	}

	@Override
    public void handleGet(HttpExchange exchange) {
        try {
            exchange.getResponseHeaders().put(CONTENT_TYPE, List.of(JSON));
            exchange.sendResponseHeaders(HttpStatusCodes.OK.getStatusCode(), 0);

            try (OutputStream outputStream = exchange.getResponseBody()) {
                outputStream.write(identifier.toJsonString().getBytes(Charset.forName(CHARSET_NAME)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}