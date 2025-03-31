package Assignment6;

public class FYEMusicReaderException extends FYEMusicException {
  public FYEMusicReaderException(String message) {
    super("Unable to load file: " + message);
  }
}
