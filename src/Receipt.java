public class Receipt {

    private final double momsSats = 0.25;
    private final String currency = "DKK";
    private final String greetings = "Tak fordi du besøgte"; //Could be local. I find it easier to locate and change here.

    public Receipt(double subtotal){
        printReceipt(subtotal, 0);
    }

    public Receipt(double subtotal, double tip){
        printReceipt(subtotal, tip);
    }


    private void printReceipt(double subtotal, double tip){
        /* local variables - only needed in this scope. */
        double subtotalWOTax = subtotal * (1 - momsSats);
        double tax = subtotal * momsSats;
        double total = subtotal + tip;

        printLogo(greetings);                                                                     //logo
        System.out.printf("Subtotal u. moms:\t\t%58s %7.2f\n", currency, subtotalWOTax); //subtotal (no tax)
        System.out.printf("Moms:\t\t%70s %7.2f\n", currency, tax);                       //tax
        if(tip>0)
            System.out.printf("Drikkepenge:\t\t%62s %7.2f\n", currency, tip);            //tip (if applicable)

        for(int i = 0; i<90;i++){
            System.out.print("=");                                                       //break line
        }
        System.out.println();                                                            //new line

        System.out.printf("Total:\t\t%70s %7.2f\n", currency, total);                     //total
    }

    private static void printLogo(String greetings){
        System.out.printf("%55s\n", greetings);
        System.out.println(
                "    _______      ____     ________     .-''-.          .--.   .--.      .-''-.     ____     \n" +
                        "   /   __  \\   .'  __ `. |        |  .'_ _   \\         |  | _/  /     .'_ _   \\  .'  __ `.  \n" +
                        "  | ,_/  \\__) /   '  \\  \\|   .----' / ( ` )   '        | (`' ) /     / ( ` )   '/   '  \\  \\ \n" +
                        ",-./  )       |___|  /  ||  _|____ . (_ o _)  |        |(_ ()_)     . (_ o _)  ||___|  /  | \n" +
                        "\\  '_ '`)        _.-`   ||_( )_   ||  (_,_)___|        | (_,_)   __ |  (_,_)___|   _.-`   | \n" +
                        " > (_)  )  __ .'   _    |(_ o._)__|'  \\   .---.        |  |\\ \\  |  |'  \\   .---..'   _    | \n" +
                        "(  .  .-'_/  )|  _( )_  ||(_,_)     \\  `-'    /        |  | \\ `'   / \\  `-'    /|  _( )_  | \n" +
                        " `-'`-'     / \\ (_ o _) /|   |       \\       /         |  |  \\    /   \\       / \\ (_ o _) / \n" +
                        "   `._____.'   '.(_,_).' '---'        `'-..-'          `--'   `'-'     `'-..-'   '.(_,_).'  \n" +
                        "                                                                                            "
        );
    }
}
