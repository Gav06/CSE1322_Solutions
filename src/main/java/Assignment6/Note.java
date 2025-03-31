package Assignment6;

public class Note implements FYENote {

    private final byte note;
    private final int timing;

    public Note(byte note, int timing) {
        this.note = note;
        this.timing = timing;
    }

    @Override
    public byte getNote() {
        return this.note;
    }

    @Override
    public int getTiming() {
        return this.timing;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "[Note=" + note + ", Timing=" + timing + "]";
    }
}
