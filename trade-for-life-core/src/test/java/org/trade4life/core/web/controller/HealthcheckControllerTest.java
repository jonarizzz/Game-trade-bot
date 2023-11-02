package org.trade4life.core.web.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.trade4life.core.fixture.UserFixture.USER_NAME;

class HealthcheckControllerTest {

    @Test
    public void shouldSayHello() {
        HealthcheckController controller = new HealthcheckController();

        String result = controller.sayHello(USER_NAME);

        assertThat(result).isEqualTo("Hello, " + USER_NAME + "!");
    }

}
