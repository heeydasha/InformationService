public class Music extends ServiceCommunicator {

     static String title;
       static String artist;

    public Music(String title, String artist) {
        super("https://itunes.apple.com/search?term=" + title + artist + "\\&limit=1");
        Music.artist = artist;
        Music.title = title;
        //Object.Argument (artist) = Artist
        //Object.Argument= Title

    }

    public static void main(String[] args) {
        Music song;
        song = new Music(title, artist);
        song.connect();

        String res = song.get();
        System.out.println(res);
    }
}
