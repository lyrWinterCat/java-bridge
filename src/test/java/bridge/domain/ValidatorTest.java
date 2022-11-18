package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    public void bridgeSizeValidator() throws Exception{
        //given
        String bridgeSize1 = "3abc";
        String bridgeSize2 = "2";

        //then
        assertThatThrownBy(()->validator.validateBridgeSize(bridgeSize1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 숫자로 입력 가능합니다.");

        assertThatThrownBy(()->validator.validateBridgeSize(bridgeSize2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3 이상 20 이하로 입력해야 합니다.");

    }

}