package com.cleancoder.args;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ArgsTest {

  Argument help = Argument.flag("h");

  @Test
  public void detectWhenHelpIsRequested() {

    ArgsMain args = ArgsMain.parametersDefinitions(help).parse(Arrays.array("-h"));

    boolean helpRequested = args.is(help);

    assertThat(helpRequested).isTrue();
  }

  @Test
  public void detectWhenHelpIsNotRequested() {
    ArgsMain args = ArgsMain.parametersDefinitions(help).parse(Arrays.array());

    boolean helpRequested = args.is(help);

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
