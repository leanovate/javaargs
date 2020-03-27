package com.cleancoder.args;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

  @Test
  public void testCreateWithNoSchemaOrArguments() {
    ArgsMain args = new ArgsMain(Arrays.array("-h"));

    boolean helpRequested = args.isHelp();

    assertThat(helpRequested).isTrue();
  }

  @Test
  public void detectWhenHelpIsNotRequested() {
    ArgsMain args = new ArgsMain(Arrays.array());

    boolean helpRequested = args.isHelp();

    assertThat(helpRequested).isFalse();
  }
}
