public class Television extends ServiceCommunicator {
    static String tvShow;

    public Television(String tvShow) {
        super("http://api.tvmaze.com/singlesearch/shows?q=" + tvShow );
        Television.tvShow = tvShow;

    }

    public static void main(String[] args) {
        Television show;
        show = new Television( tvShow);
        show.connect();

        String res = show.get();
        System.out.println(res);

    }
}
