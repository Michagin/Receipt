public class Receipt {

    double total;
    double subtotal;
    double tax;
    double tip = 0;
    double subtotalWOTax;
    double momsSats = 0.25;
    String currency = "DKK";

    public Receipt(double subtotal){
        this.subtotal = subtotal;
        printReceipt(subtotal, 0);
    }

    public Receipt(double subtotal, double tip){
        this.total = subtotal;
        this.tip = tip;
        printReceipt(subtotal, tip);
    }


    private void printReceipt(double subtotal, double tip){
        this.subtotal = subtotal;
        subtotalWOTax = subtotal * (1-momsSats);
        tax = subtotal * momsSats;
        total = subtotal + tip;



        printlogo(); //logo
        System.out.printf("Subtotal u. moms:\t\t%58s %7.2f\n", currency, subtotalWOTax); //total
        System.out.printf("Moms:\t\t%70s %7.2f\n", currency, tax); //tax
        if(tip>0)
            System.out.printf("Drikkepenge:\t\t%62s %7.2f\n", currency, tip); //tip

        for(int i = 0; i<90;i++){
            System.out.print("="); // breakline
        }
        System.out.println(); //newline

        System.out.printf("Total:\t\t%70s %7.2f\n", currency,total); //total
    }

    public static void printlogo(){
        String greetings = "Tak fordi du besøgte";

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
