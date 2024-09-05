package org.example.socialmedia;

public class SimplePost implements Post {

    String message;

    @Override
    public Void setMessage(String message) {
        this.message = message;
        return null;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
