package MidtermPractice;

public abstract class MusicPlayer implements IPlayable {

    @Override
    public void start(String songName) {
        System.out.println("I'm playing");
    }

    @Override
    public void stop(String songName) {
        System.out.println("I'm stopping");
    }

    public abstract void pause(String songName);

    public abstract void unpause(String songName);

}
