package org.mule.consulting.totp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.junit.Test;

public class TotpOperationsTestCase extends MuleArtifactFunctionalTestCase {

  /**
   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
   */
  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Test
  public void executeGenerateOperation() throws Exception {
    String payloadValue = ((String) flowRunner("generateFlow").run()
                                      .getMessage()
                                      .getPayload()
                                      .getValue());
  }

  @Test
  public void executeValidateOperation() throws Exception {
    String payloadValue = ((String) flowRunner("validateFlow")
                                      .run()
                                      .getMessage()
                                      .getPayload()
                                      .getValue());
  }
}
