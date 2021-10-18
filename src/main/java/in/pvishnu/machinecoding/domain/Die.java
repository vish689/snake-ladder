package in.pvishnu.machinecoding.domain;

import lombok.AllArgsConstructor;

import java.util.Random;

public class Die {

    private final int faces;
    private final Random random = new Random();

    public Die(int faces) {
        this.faces = faces;
    }

    public int rollDie() {
        return random.nextInt(faces) + 1;
    }

}
