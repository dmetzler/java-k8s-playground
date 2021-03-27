/*
 * (C) Copyright 2020 Nuxeo (http://nuxeo.com/).
 * This is unpublished proprietary source code of Nuxeo SA. All rights reserved.
 * Notice of copyright on this source code does not indicate publication.
 *
 * Contributors:
 *     dmetzler
 */
package org.dmetzler;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

/**
 * From an idea of jpetazzo: https://github.com/jpetazzo/webcolor Shows a web page with the background color being
 * computed from the pod name.
 */
@ApplicationScoped
public class LandingRoute {

    @Route(path = "/", methods = HttpMethod.GET)
    public void landing(RoutingContext rc) {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "localhost";
        }
        String color = hostname.split("-")[0];

        rc.response()
          .end(String.format(
                  "<!DOCTYPE html>\n" + "<html>\n" + "  <body style=\"background: %s;\">\n"
                          + "    <h1 style=\"background: white;\">This is pod %s.</h1>\n" + "  </body>\n" + "</html>",
                  color, hostname));
    }
}
