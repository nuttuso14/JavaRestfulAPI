package org.matt.restmongo.restfulmongo;

public class PlayerNotFoundException extends RuntimeException {
    PlayerNotFoundException(int id) {
        super("Could not find player number: " + id);
    }
}
