package com.cleancoder.args;

import java.util.Arrays;
import java.util.List;

public class ArgsMain {

    private final List<String> givenArgs;

    public ArgsMain(String[] givenArgs) {
        this.givenArgs = Arrays.asList(givenArgs);
    }

    boolean isHelp() {
        return givenArgs.contains("-h");
    }
}
