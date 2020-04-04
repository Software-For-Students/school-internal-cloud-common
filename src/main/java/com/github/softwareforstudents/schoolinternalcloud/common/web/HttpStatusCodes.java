package com.github.softwareforstudents.schoolinternalcloud.common.web;

import java.util.stream.Stream;

//according to: https://www.w3schools.com/tags/ref_httpmessages.asp
public enum HttpStatusCodes {

    //made up status code used by search
    UNKNOWN(-1),

    //information
    CONTINUE(100),
    SWITCHING_PROTOCOLS(101),
    CHECKPOINT(103),

    //successful
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NON_AUTHORITATIVE_INFORMATION(203),
    NO_CONTENT(204),
    RESET_CONTENT(205),
    PARTIAL_CONTENT(206),

    //redirection
    MULTIPLE_CHOICES(300),
    MOVED_PERMANENTLY(301),
    FOUND(302),
    SEE_OTHER(303),
    NOT_MODIFIED(304),
    SWITCH_PROXY(306),
    TEMPORARY_REDIRECT(307),
    RESUME_INCOMPLETE(308),

    //client error
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    PAYMENT_REQUIRED(402),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    PROXY_AUTHENTICATION_REQUIRED(407),
    REQUEST_TIMEOUT(408),
    CONFLICT(409),
    GONE(410),
    LENGTH_REQUIRED(411),
    PRECONDITION_FAILED(412),
    REQUEST_ENTITY_TOO_LARGE(413),
    REQUEST_URI_TOO_LONG(414),
    UNSUPPORTED_MEDIA_TYPE(415),
    REQUESTED_RANGE_NOT_SATISFIABLE(416),
    EXPECTATION_FAILED(417),

    //server error
    INTERNAL_SERVER_ERROR(500),
    NOT_IMPLMENTED(501),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504),
    HTTP_VERSION_NOT_SUPPORTED(505),
    NETWORK_AUTHENTICATION_REQUIRED(511);

    private int code;

    private HttpStatusCodes(final int code) {
        this.code = code;
    }

    public int getStatusCode() {
        return this.code;
    }

    public static HttpStatusCodes getByStatusCode(final int code) {
        return Stream.of(HttpStatusCodes.values()).filter(value -> value.getStatusCode() == code).findAny().orElse(UNKNOWN);
    }

}