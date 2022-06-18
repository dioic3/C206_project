import br.inatel.cdg.Comojogar;
import br.inatel.cdg.Conections.rankingDAO;
import br.inatel.cdg.Entrada;
import br.inatel.cdg.controller.Jogar;
import br.inatel.cdg.models.Jogador;
import br.inatel.cdg.models.MenuPrincipal;
import br.inatel.cdg.models.Ranking;
import br.inatel.cdg.Conections.jogadorDAO;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        rankingDAO rankingBD = new rankingDAO();
         // criar funçao para ler BD
        jogadorDAO jogadorBD = new jogadorDAO();


        Scanner sc = new Scanner(System.in);
        Entrada entrada = new Entrada();
        boolean flag = true;
        String jogarnovamente;
        Jogador jogador;
        long tempoInicial;
        long tempoFinal;
        long tempoGasto;
        int i = 0;
        int NumPassos = 100;
        Jogador jogadores[];
        int anterior;

        String peDireito = null;
        String passoanterior;
        String passoatual;

        boolean primeiravez = true;

        while (flag) {
            Ranking ranking = rankingBD.recuperaRankOrdenado();
            if (primeiravez) {
                System.out.println("BEM VINDO");
            }
            primeiravez = false;
            MenuPrincipal menuPrincipal = MenuPrincipal.pegarUsuario();
            switch(menuPrincipal) {
                case JOGAR:
                    Jogar jogar = new Jogar();
                    jogar.main();
                    break;
                case COMO_JOGAR:
                    Comojogar.Comojogartexto();
                    try {
                        TimeUnit.SECONDS.sleep(22);
                        System.out.println(" PREPARADO? SE ESTIVER, DIGITE 1 PARA JOGAR ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case MOSTRAR_RANKING:
                    System.out.println("___________________________");
                    ranking.mostrarRank();
                    System.out.println("___________________________");
                    sc.nextLine();
                    break;
                case SAIR:
                    System.out.println("TCHAU TCHAU");
                    flag = false;
                    break;
            }
        }

    }
}
