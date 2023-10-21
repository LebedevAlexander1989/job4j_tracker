package ru.job4j.tracker.output;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidMultipleInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);

        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
    }

    @Test
    public void whenInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}
