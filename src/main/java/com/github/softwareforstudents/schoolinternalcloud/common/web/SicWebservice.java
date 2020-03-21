package com.github.softwareforstudents.schoolinternalcloud.common.web;

import com.github.softwareforstudents.schoolinternalcloud.common.service.ServiceIdentifier;
import com.github.softwareforstudents.schoolinternalcloud.common.web.shared.DiscoveryRoute;
import com.github.softwareforstudents.schoolinternalcloud.common.web.shared.HeartbeatRoute;

public class SicWebservice extends Webservice {

    public final static String HEARTBEAT_PATH = "/heartbeat/";
    public final static String DISCOVERY_PATH = "/discovery/";

    public SicWebservice(int port, ServiceIdentifier identifier) {
        super(port);

        this.registerRoute(HEARTBEAT_PATH, new HeartbeatRoute());
        this.registerRoute(DISCOVERY_PATH, new DiscoveryRoute(identifier));
    }
}