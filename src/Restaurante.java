import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    public static ArrayList<String> pedidos = new ArrayList<>();
    public static ArrayList<String> getPizzas = Cardapio.getPizzas();

    public static void Menu(Integer num){

        Scanner sc = new Scanner(System.in);

        switch (num){
            case 0:
                System.out.println("Sistema de pedidos  \n");
                System.out.println("1. Cadastrar pedido");
                System.out.println("2. Editar pedido");
                System.out.println("3. Sair \n");
                System.out.println("Digite sua escolha: ");

                Integer escolha = sc.nextInt();
                Menu(escolha);

                break;
            case 1:
                System.out.println("Menu/Cadastro \n");

                boolean infoPedido = true;
                boolean statusMesa = true;

                String Mesa = "";

                while (statusMesa) {
                    System.out.println("Informe o numero da mesa: (1-10)");
                    String mesa = sc.nextLine();

                    if (Integer.parseInt(mesa) >= 1 && Integer.parseInt(mesa) <= 10) {
                        System.out.println("Mesa escolhida: " + mesa);
                        Mesa = mesa;
                        statusMesa = false;
                    }else {
                        System.out.println("A mesa tem que ser maior ou igual que 1 e menor ou igual a 10.");
                    }
                }

                for (int in = 0; in < getPizzas.size(); in++) {
                    System.out.println((in + 1) + " - " + getPizzas.get(in) + " : " + Cardapio.getPizzaDesc(getPizzas.get((in))));
                }

            while (infoPedido) {
                boolean statusPedido = true;

                String Pedido = "";

                while (statusPedido) {
                    System.out.println("Informe os pedidos: (ID)");
                    String pedido = sc.nextLine();

                    if (getPizzas.size() >= Integer.parseInt(pedido) && getPizzas.get(Integer.parseInt(pedido) - 1) != null) {
                        statusPedido = false;
                        System.out.println("Pizza escolhida: " + getPizzas.get(Integer.parseInt(pedido) - 1));
                        Pedido = getPizzas.get(Integer.parseInt(pedido) - 1);
                    }else {
                        System.out.println("O id não corresponde ha nenhuma pizza.");
                    }
                }
                boolean statusQuantia = true;
                while (statusQuantia) {
                    System.out.println("Informe a quantia: ");
                    String Id = sc.nextLine();

                    if (Integer.parseInt(Id) >= 1) {
                        statusQuantia = false;
                        pedidos.add(Mesa + "-" + Pedido + "-" + Id);
                        System.out.println("Pedido finalizado");
                        System.out.println("Deseja adicionar mais coisas? (S/N)");
                        String continuar = sc.nextLine();

                        if (continuar.equalsIgnoreCase("N")) {
                            infoPedido = false;
                        }

                    } else {
                        System.out.println("O numero não pode ser menor que 1.");
                    }
                }

            }

                System.out.println("Pedidos feitos: ");

            float valorTotal = 0;

            for (int i = 0; i < pedidos.size(); i++) {
                String[] infos = pedidos.get(i).split("-");
                if (infos[0].equals(Mesa)) {
                    System.out.println(infos[2] + " - " + infos[1]);
                    valorTotal += (Double.valueOf(Cardapio.getPizzaPrecos(infos[1])) * Integer.parseInt(infos[2]));
                }
            }

            System.out.println("Valor total: R$" + valorTotal);
            System.out.println(" ");
            Menu(0);

            break;
            case 2:
                System.out.println("Menu/Editar pedido \n");

                        System.out.println("1. Remover itens");
                        System.out.println("2. Cancelar pedido");
                        System.out.println("3. Voltar");
                        System.out.println(" ");
                        System.out.println("Digite sua escolha: ");

                        Integer esc = sc.nextInt();

                        switch (esc){
                            case 1:
                                Menu (4);
                                break;
                            case 2:
                                Menu(5);
                                break;
                            case 3:
                                Menu(0);
                                break;
                            default:
                                Menu(0);
                                break;
                        }

            case 3:
                System.out.println("Sistema finalizado !");
                break;

            case 4:
                System.out.println("Informe a mesa: (1-10)");
                String mesa = sc.nextLine();
                ArrayList<String> pedidosmesa = new ArrayList<>();

                for (int i = 0; i < pedidos.size(); i++) {
                    String[] infos = pedidos.get(i).split("-");
                    if (infos[0].equals(mesa)) {
                        pedidosmesa.add(infos[2] + " - " + infos[1] + " - " + i);
                    }
                }
                for (int l = 0; l < pedidosmesa.size(); l++) {
                    System.out.println((l+1) + " | " + pedidosmesa.get(l));
                }
                boolean itemremover = true;
                while (itemremover) {
                    System.out.println("Informe o item para remover: ");
                    Integer remover = sc.nextInt();
                    if(remover >= 1 && remover <= pedidosmesa.size()){
                        itemremover = false;
                        String[] item = pedidosmesa.get(remover-1).split("-");
                        pedidosmesa.remove(remover-1);
                        pedidos.remove(item[2]);
                        System.out.println("Pedido removido");
                        for (int l = 0; l < pedidosmesa.size(); l++) {
                            System.out.println((l+1) + " | " + pedidosmesa.get(l));
                        }
                        Menu(0);
                    }else {
                        System.out.println("Não existe esse item");
                    }
                }

               break;

            case 5:
                System.out.println("Informe a mesa: (1-10)");
                String mesacancelar = sc.nextLine();

                for (int j = 0; j < pedidos.size(); j++){
                    String[] item = pedidos.get(j).split("-");
                    if (item[0].equals(mesacancelar)) {
                        pedidos.remove(j);
                        System.out.println(" ");
                        System.out.println("Pedido cancelado na mesa: " + mesacancelar);
                        System.out.println(" ");
                        for (int i = 0; i < pedidos.size(); i++) {
                           System.out.println(pedidos.get(i));
                            }
                    }
                }
                Menu(0);
            break;
        }
    }
    public static void main(String[] args) {
        Menu(0);
    }
}