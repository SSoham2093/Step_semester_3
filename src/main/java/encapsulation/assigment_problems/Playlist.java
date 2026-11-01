package encapsulation.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
    }

    public void addSong(String title) {
        if (count == songs.length) {
            System.out.println("Cannot add " + title + ": playlist is full");
            return;
        }
        songs[count++] = title;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("copy[0] = " + copy[0]);
        System.out.println("p.getSongs()[0] = " + p.getSongs()[0]);
        System.out.println("getSongCount() -> " + p.getSongCount());
    }
}
