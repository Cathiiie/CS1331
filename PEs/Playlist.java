import java.util.Scanner;
import java.util.Random;
public class Playlist {
    public static void addPlaylistInfo(Scanner scanin) {
        System.out.print("Enter number of songs in playlist: ");
        int numSongs = scanin.nextInt();
        scanin.nextLine();
        System.out.print("Enter a playlist name: ");
        String playlistName = scanin.nextLine();

        System.out.println("Playlist created successfully. Here are the details: ");
        System.out.println("Number of Songs: " + numSongs);
        System.out.println("Name: " + playlistName);
    }
    public static int[] genreTally(String[] genreArray, String[] genres) {
        System.out.println("The following types of genres are in your playlist:");
        int[] countGenres = new int[genres.length];
        for (int i = 0; i < genres.length; i++) {
            countGenres[i] = 0;
            for (int j = 0; j < genreArray.length; j++) {
                if ((genreArray[j].equals(genres[i]))) {
                    countGenres[i]++;
                }
            }
            System.out.println(genres[i] + " " + countGenres[i]);
        }
        return countGenres;
    }
    public static void playlistScores(String[] playlist1, String[] playlist2, String[] genres) {
        int[] play1Array = new int[genres.length];
        int[] play2Array = new int[genres.length];
        play1Array = genreTally(playlist1, genres);
        play2Array = genreTally(playlist2, genres);
        int play1Score = 0;
        int play2Score = 0;
        for (int i = 0; i < genres.length; i++) {
            play1Score += play1Array[i] * i;
            play2Score += play2Array[i] * i;
        }
        if (play1Score > play2Score) {
            System.out.println("The first playlist is likely to have more listeners than the second.");
        } else if (play1Score < play2Score) {
            System.out.println("The second playlist is likely to have more listeners than the first.");
        } else {
            System.out.println("The two playlists are predicted to perform equally well.");
        }
    }
    public static void main(String[] args) {
        String[] genres = {"Rap", "Pop", "Classical", "Hip Hop", "Rock", "Lo Fi"};
        String[] playlist1 = new String[7];
        String[] playlist2 = new String[7];
        Random rand = new Random();
        for (int i = 0; i < playlist1.length; i++) {
            playlist1[i] = genres[rand.nextInt(genres.length)];
            playlist2[i] = genres[rand.nextInt(genres.length)];
        }
        Scanner scan = new Scanner(System.in);
        addPlaylistInfo(scan);
        addPlaylistInfo(scan);
        genreTally(playlist1, genres);
        genreTally(playlist2, genres);
        playlistScores(playlist1, playlist2, genres);
    }
}
