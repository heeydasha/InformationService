public class Zipcode extends ServiceCommunicator {
    static String zipcode;

    public Zipcode( String zipcode) {
        super("http://api.zippopotam.us/us/" + zipcode);
        Zipcode.zipcode = zipcode;
    }

    //public String getZipcode() {
       // return zipcode;
   // }

    //public void setZipcode(String zipcode) {
        //this.zipcode = zipcode;
   // }

    public static void main(String[] args) {
       // written to test class
        Zipcode z ;
         z = new Zipcode( zipcode);
         z.connect();
         String res = z.get();
         System.out.println( res);

    }
}
