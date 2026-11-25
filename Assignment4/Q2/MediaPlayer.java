import java.util.*;

public class MediaPlayer {
    private LinkedList<Song> playlist;
    private LinkedList<Song> recentlyPlayed;
    private ListIterator<Song> iterator;
    public MediaPlayer() {
        playlist = new LinkedList<>();
        recentlyPlayed = new LinkedList<>();
        iterator = playlist.listIterator();
    }
    public void addSong(Song song, int position) {
        if (position < 0 || position > playlist.size()) {
            System.out.println("Invalid position!");
            return;
        }
        playlist.add(position, song);
        iterator = playlist.listIterator();
        System.out.println("Song added: " + song);
    }

    public void addPrioritySong(Song song) {
        playlist.addFirst(song);
        iterator = playlist.listIterator();
        System.out.println("Priority song added: " + song);
    }

    public void addSongAtEnd(Song song) {
        playlist.addLast(song);
        iterator = playlist.listIterator();
        System.out.println("Song added: " + song);
    }

    public void removeSong(int songId) {
        boolean removed = playlist.removeIf(
            song -> song.getSongId() == songId
        );
        if (removed) {
            iterator = playlist.listIterator();
            System.out.println("Song removed successfully.");
        }
        else {
            System.out.println("Song not found!");
        }
    }

    public void removeDuplicates() {
        HashSet<Integer> seen = new HashSet<>();
        ListIterator<Song> itr = playlist.listIterator();
        while (itr.hasNext()) {
            Song song = itr.next();
            if (!seen.add(song.getSongId())) {
                itr.remove();
            }
        }
        iterator = playlist.listIterator();
        System.out.println("Duplicate songs removed.");
    }

    public void playNext() {
        if (iterator.hasNext()) {
            Song song = iterator.next();
            recentlyPlayed.addLast(song);
            System.out.println("Now Playing: " + song);
        }
        else {
            System.out.println("End of playlist reached!");
        }
    }

    public void playPrevious() {
        if (iterator.hasPrevious()) {
            Song song = iterator.previous();
            recentlyPlayed.addLast(song);
            System.out.println("Now Playing: " + song);
        }
        else {
            System.out.println("Beginning of playlist reached!");
        }
    }

    public void displayPlaylist() {
        System.out.println("\n--- PLAYLIST ---");
        ListIterator<Song> itr = playlist.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public void displayPlaylistBackward() {
        System.out.println("\n--- REVERSE PLAYLIST ---");
        ListIterator<Song> itr = playlist.listIterator(playlist.size());
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }

    public void displayHistory() {
        System.out.println("\n--- RECENTLY PLAYED ---");
        if (recentlyPlayed.isEmpty()) {
            System.out.println("No playback history.");
            return;
        }
        ListIterator<Song> itr = recentlyPlayed.listIterator(recentlyPlayed.size());
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }

    public void displaySongCount() {
        System.out.println("Total songs in playlist: " + playlist.size());
    }
}
