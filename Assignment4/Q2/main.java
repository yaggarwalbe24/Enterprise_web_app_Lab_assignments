public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        Song s1 = new Song(1, "Perfect", "Ed Sheeran");
        Song s2 = new Song(2, "Believer", "Imagine Dragons");
        Song s3 = new Song(3, "Closer", "The Chainsmokers");
        Song s4 = new Song(4, "Memories", "Maroon 5");
        Song s5 = new Song(5, "Attention", "Charlie Puth");

        player.addSong(s1, 0);
        player.addSong(s2, 1);
        player.addSong(s3, 2);
        player.addSong(s4, 3);

        player.addPrioritySong(s5);

        player.displayPlaylist();

        player.addSong(s1, 3);

        player.removeDuplicates();

        player.displayPlaylist();

        player.displaySongCount();

        System.out.println("\n--- PLAYBACK ---");

        player.playNext();
        player.playNext();
        player.playNext();

        player.playPrevious();

        player.playNext();

        player.displayHistory();

        player.displayPlaylistBackward();

        player.removeSong(3);

        player.displayPlaylist();

        player.displaySongCount();
    }
}
