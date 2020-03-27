package com.cleancoder.args;

import java.util.Arrays;
import java.util.List;

public class ArgsMain {

    private final List<String> givenArgs;

    public ArgsMain(String[] givenArgs) {
        this.givenArgs = Arrays.asList(givenArgs);

        if (this.givenArgs.stream().anyMatch(arg -> !isAllowed(arg)))
            throw new IllegalArgumentException("Parameter -u is not supported");
    }

    boolean isHelp() {
        return givenArgs.contains("-h");
    }

    private boolean isAllowed(String arg) {
        return arg.equals("-h");
    }
}
