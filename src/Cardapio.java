import java.util.ArrayList;

public class Cardapio {

    public static ArrayList<String> list = new ArrayList<String>();

    public static ArrayList<String> getPizzas() {

        list.add("Marguerita");
        list.add("Calabresa");
        list.add("Portuguesa");
        list.add("Baiana");
        list.add("Lombo");
        list.add("Frango com catupiry");

        return list;
    }


    public static String getPizzaDesc(String name) {

        String desc = "";

        switch (name.toLowerCase()) {
            case "marguerita":
                desc = "Mussarela, Tomate e Majericão";
                break;
            case "calabresa":
                desc = "Mussarela, Calabresa e Cebola";
                break;
            case "portuguesa":
                desc = "Mussarela, Presunto, Ovo e Cebola";
                break;
            case "baiana":
                desc = "Mussarela, Calabresa, Cebola e Pimenta";
                break;
            case "lombo":
                desc = "Mussarela e Lombo";
                break;
            case "frango com catupiry":
                desc = "Mussarela, Frango e Catupiry";
                break;
            default:
                desc = "A pizza não foi encontrada.";
                break;
        }
        return desc;
    }

    public static double getPizzaPrecos(String name) {

        double precos;

        switch (name.toLowerCase()) {
            case "marguerita":
                precos = 49.99;
                break;
            case "calabresa":
                precos = 69.99;
                break;
            case "portuguesa":
                precos = 59.99;
                break;
            case "baiana":
                precos = 54.99;
                break;
            case "lombo":
                precos = 64.99;
                break;
            case "frango com catupiry":
                precos = 74.99;
                break;
            default:
                precos = 0;
                break;
        }
        return precos;
    }
}
