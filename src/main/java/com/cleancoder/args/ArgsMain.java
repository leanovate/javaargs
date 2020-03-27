package com.cleancoder.args;

import java.util.Arrays;
import java.util.List;

public class ArgsMain {

    private final List<String> givenArgs;

    public ArgsMain(String[] givenArgs) {
        this.givenArgs = Arrays.asList(givenArgs);
        if (this.givenArgs.contains("-u"))
            throw new IllegalArgumentException("Parameter -u is not supported");
    }

    boolean isHelp() {
        return givenArgs.contains("-h");
    }
}
