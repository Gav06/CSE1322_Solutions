package Assignment6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment6 {

    public static ArrayList<FYENote> loadMusic(FileInputStream fis) throws IOException, FYEMusicReaderException {
        final ArrayList<FYENote> noteList = new ArrayList<>();

        // read first byte to determine how many fyenotes we have
        if (fis.available() == 0) {
            throw new FYEMusicReaderException("File is empty");
        }

        byte amount = (byte) fis.read();

        if (amount < 0) {
            throw new FYEMusicReaderException("Note counter is out of range");
        }

        if (fis.available() / 2 < amount) {
            throw new FYEMusicReaderException("File ended abruptly");
        }

        // we read notes in pairs of bytes (16 bits per note total)
        for (byte i = 0; i < amount; i++) {
            if (fis.available() < 2) {
                throw new FYEMusicReaderException("File ended abruptly");
            }

            byte note = (byte) fis.read();

            if (note < 0) {
                throw new FYEMusicReaderException("Note out of range");
            }

            int timing = fis.read();

            if (timing < 0 || timing > 127) {
                throw new FYEMusicReaderException("Timing out of range");
            }

            // convert timing from 1/16ths of a second to microseconds
            final int sixteenth = 1000000 / 16;
            timing *= sixteenth;

            noteList.add(new Note(note, timing));
        }



        return noteList;
    }

    public static void main(String[] args) {
        System.out.println("[FYE Music Player]");
        boolean running = true;
        final Scanner scanner = new Scanner(System.in);
            while (running) {
                System.out.println("1. Load music");
                System.out.println("2. Play music");
                System.out.println("3. Quit");
                System.out.print("Enter option: ");
                final int option = Integer.parseInt(scanner.nextLine());

                try {
                    switch (option) {
                        case 1:
                            System.out.print("Enter name of music file: ");
                            final String fname = scanner.nextLine();
                            final FileInputStream fis = new FileInputStream(fname);
                            final ArrayList<FYENote> notes = loadMusic(fis);
                            FYEMusicPlayer.loadNotes(notes);
                            System.out.println("Music loaded.");
                            fis.close();

                            break;
                        case 2:
                            System.out.println("Playing music...");
                            FYEMusicPlayer.play();
                            System.out.println("Done playing.");
                            break;
                        case 3:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                } catch (IOException | FYEMusicReaderException | FYEMusicPlayerException e) {
                    System.out.println(e.getMessage());
                }
            }

        System.out.println("Shutting off...");
        scanner.close();
    }
}
