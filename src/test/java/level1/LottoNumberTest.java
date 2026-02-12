package level1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25, 45})
    @DisplayName("1부터 45 사이의 숫자로 로또 번호를 생성할 수 있다.")
    void createLottoNumberSuccess(int value) {
        LottoNumber lottoNumber = new LottoNumber(value);
        assertThat(lottoNumber.getValue()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "25", "45"})
    @DisplayName("문자열 숫자로도 로또 번호를 생성할 수 있다.")
    void createLottoNumberByStringSuccess(String value) {
        LottoNumber lottoNumber = new LottoNumber(value);
        assertThat(lottoNumber.getValue()).isEqualTo(Integer.parseInt(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    @DisplayName("1~45 범위를 벗어나는 숫자는 예외가 발생한다.")
    void createLottoNumberRangeFail(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1 - 45 범위 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "", "!!"})
    @DisplayName("숫자가 아닌 문자열을 입력하면 예외가 발생한다.")
    void createLottoNumberFormatFail(String value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("값이 같은 두 로또 번호 객체는 동등하다(equals).")
    void equalsAndHashCodeTest() {
        LottoNumber number1 = new LottoNumber(10);
        LottoNumber number2 = new LottoNumber(10);

        assertThat(number1).isEqualTo(number2);
        assertThat(number1.hashCode()).isEqualTo(number2.hashCode());
    }
}