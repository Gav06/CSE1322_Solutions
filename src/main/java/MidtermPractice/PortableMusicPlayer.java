package MidtermPractice;

public class PortableMusicPlayer extends MusicPlayer {

    @Override
    public void pause(String songName) {
        System.out.println("I'm Pausing");
    }

    @Override
    public void unpause(String songName) {
        System.out.println("I'm unpausing");
    }
}

// for question 6
class Test {

    private void test() {

        IPlayable player = new PortableMusicPlayer();
        PortableMusicPlayer portableMusicPlayer = new PortableMusicPlayer();
    }
}