package br.inatel.cdg;

import excessoes.Excesaum;
import excessoes.ExcessaoQueisso;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Scanner;

public class Entrada {
    private String entradaint;
    private int returnnumero;
    private String  entradaqueimou;
    Scanner entrada = new Scanner(System.in);





    public int Menu() throws Excesaum {
        entradaint = entrada.nextLine();

        if(!Objects.equals(entradaint, "1") && !Objects.equals(entradaint, "2") && !Objects.equals(entradaint, "3") && !Objects.equals(entradaint, "4")){

            throw new Excesaum("DADO INVALIDO, FAVOR INSERIR UMA DAS OPÇÕES DISPONÍVEIS NO MENU DO JOGO.");


        }else {
            returnnumero =Integer.parseInt(entradaint);
            return returnnumero;
        }


    }

    public static void QueimouaLargada() throws ExcessaoQueisso{


    }
}