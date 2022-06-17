package br.inatel.cdg.models;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public enum MenuPrincipal {
    JOGAR(1, "Jogar"),
    COMO_JOGAR(2 , "Como jogar"),
    MOSTRAR_RANKING( 3,  "Ranking dos Melhores Jogadores"),
    SAIR( 4, "Sair");
    private final int id;
    private final String label;
    private static final Map<Integer, MenuPrincipal> map = new HashMap<>();
    MenuPrincipal(int id, String label){
        this.id = id;
        this.label = label;
    }
    static {
        for(MenuPrincipal menuPrincipal : MenuPrincipal.values()){
            map.put(menuPrincipal.id, menuPrincipal);
        }
    }
    public int getId(){
        return id;
    }
    public static MenuPrincipal pegarUsuario(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Seja bem-vindo ao Joguinho!");
            System.out.println("___________________________");
            MenuPrincipal.imprimirOpcoes();
            System.out.println("___________________________");
            System.out.println("Insira sua opção:");
            int id = input.nextInt();
            MenuPrincipal menuPrincipal = MenuPrincipal.pegarOpcao(id);
            if(menuPrincipal != null)
                return menuPrincipal;
            System.out.println("Erro! Opção inválida.");
        }
    }

    public static void imprimirOpcoes(){
        for(MenuPrincipal menuPrincipal : MenuPrincipal.values()){
            System.out.println(menuPrincipal);
        }
    }
    @Override
    public String toString(){
        return id+". "+label;
    }
    public static MenuPrincipal pegarOpcao(int id){
        if(map.containsKey(id))
            return map.get(id);
        return null;
    }
}
