package Assignment3;

public class VideoGame extends Software {
    private boolean multiplayerSupport;

    public VideoGame(String name, double price, String publisher, boolean multiplayerSupport) {
        super(name, price, publisher);
        this.multiplayerSupport = multiplayerSupport;
    }

    public boolean hasMultiplayerSupport() {
        return multiplayerSupport;
    }

    public void setMultiplayerSupport(boolean multiplayerSupport) {
        this.multiplayerSupport = multiplayerSupport;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t\tMultiplayer support: " + multiplayerSupport;
    }
}