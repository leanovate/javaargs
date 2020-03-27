package com.cleancoder.args;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ArgsTest {

  @Test
  public void detectWhenHelpIsRequested() {
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

  @Test
  public void shouldThrowIllegalArgumentExceptionOnUnknownArg() {
    assertThatIllegalArgumentException()
            .isThrownBy(() -> new ArgsMain(Arrays.array("-u")))
            .withMessage("Parameter -u is not supported");

    assertThatIllegalArgumentException()
            .isThrownBy(() -> new ArgsMain(Arrays.array("-k")))
            .withMessage("Parameter -k is not supported");
  }
}
