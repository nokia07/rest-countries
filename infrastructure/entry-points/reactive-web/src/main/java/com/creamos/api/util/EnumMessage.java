package com.creamos.api.util;

public class EnumMessage {
    public enum Message {
        MESSAGE200("Successful"),
        MESSAGE201("Created successfully"),
        MESSAGE404("Register doesn't exist"),
        MESSAGE401("Denied access"),
        MESSAGE500("Internal Server Error"),
        MESSAGE400("Bad Request");

        private final String value;

        private Message(String value) {
            this.value = value;
        }

        public String getMessage() {
            return value;
        }
    }
}
