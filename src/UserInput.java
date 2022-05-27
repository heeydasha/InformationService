import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInput {
    private ArrayList<String> args;             // Where to store user's input (collection of string tokens)
    private Scanner userinput;                  // To see if there was any data was input
    private Scanner tokens;                     // parsing what the user input


//     Basic Constructor

   UserInput() {
        userinput = new Scanner(System.in);
        args = new ArrayList<String>();
    }


//     clear the list of user input tokens

    public void clear() {
        args = new ArrayList<String>();
    }

    public String getCommand() {
        return args.get(0);
    }

    public int numargs() {
        return args.size();
    }

    public ArrayList<String> getArgs() {
        if (userinput.hasNextLine()) {                  // If the user typed something... even just a <CR>
            String cmd = userinput.nextLine();

            if (cmd.isEmpty() == false) {             // If the user typed some words.

                tokens = new Scanner(cmd);              // break up the line into words
                while (tokens.hasNext()) {             // While there are words in the input, print them
                    args.add(tokens.next());
                }
            }
        }
        return args;
    }

    public void displayArgs() {
        for (int i = 0; i < numargs(); i++ ) {
            System.out.println("Arg: " + i + "  = [" + args.get(i) + "]");
        }
    }


    public static void main(String[] argv) {
        UserInput ui = new UserInput();
        ArrayList <String> userArgs;

        while (true) {
            ui.clear();
            System.out.print("Command> ");                  // show prompt to user

            userArgs = ui.getArgs();
            switch(ui.getCommand().toLowerCase(Locale.ROOT)) {
                case "zipcode":
                    Zipcode z ;
                    z =  new Zipcode( userArgs.get( 1 ));
                    z.connect();
                    String res = z.get();
                    System.out.println( res);
                    //                    ui.displayArgs();
                    break;
                case "itunes":
                    Music song;
                    song = new Music(userArgs.get(1) , "");
                    song.connect();

                    String res1 = song.get();
                    System.out.println(res1);
//                    ui.displayArgs();
                    break;
                case "tv":
                    Television show;
                    show = new Television( userArgs.get(1));
                    show.connect();

                    String res2 = show.get();
                    System.out.println(res2);

                            defualt:
                    System.out.println("error");
                    break;
            }

            ui.clear();
        }
    }
}
