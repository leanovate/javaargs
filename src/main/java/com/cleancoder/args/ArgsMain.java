package com.cleancoder.args;

import java.util.Arrays;
import java.util.List;

public class ArgsMain {

    private final List<String> givenArgs;

    public ArgsMain(String[] givenArgs) {
        this.givenArgs = Arrays.asList(givenArgs);

        this.givenArgs.stream()
                .filter(arg -> !isAllowed(arg))
                .findFirst()
                .ifPresent(unsupported -> {
                    throw new IllegalArgumentException("Parameter " + unsupported + " is not supported");
                });
    }

    public static Parser parametersDefinitions(Argument help) {
        return null;
    }

    public boolean is(Argument help) {
        return false;
    }

    public static class Parser {
        public ArgsMain parse(String[] givenArgs) {
            return null;
        }
    }

    boolean isHelp() {
        return givenArgs.contains("-h");
    }

    private boolean isAllowed(String arg) {
        return arg.equals("-h");
    }
}
