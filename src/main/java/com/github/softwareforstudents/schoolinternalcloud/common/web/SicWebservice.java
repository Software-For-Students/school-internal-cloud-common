package com.github.softwareforstudents.schoolinternalcloud.common.web;

import com.github.softwareforstudents.schoolinternalcloud.common.web.shared.HeartbeatRoute;
import com.github.softwareforstudents.schoolinternalcloud.common.web.shared.ServiceIdentifier;

public class SicWebservice extends Webservice {

    public SicWebservice(int port, ServiceIdentifier identifier) {
        super(port);

        this.registerRoute("/heartbeat/", new HeartbeatRoute());
    }
}