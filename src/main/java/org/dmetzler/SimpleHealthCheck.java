/*
 * (C) Copyright 2020 Nuxeo (http://nuxeo.com/).
 * This is unpublished proprietary source code of Nuxeo SA. All rights reserved.
 * Notice of copyright on this source code does not indicate publication.
 *
 * Contributors:
 *     dmetzler
 */
package org.dmetzler;

import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

@Liveness
@Readiness
@Singleton
@Default
public class SimpleHealthCheck implements HealthCheck {

    boolean up = true;

    @Override
    public HealthCheckResponse call() {
        return up ? HealthCheckResponse.up("App is up") : HealthCheckResponse.down("App is down");
    }
}