package br.inatel.cdg.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public enum Move {
    RIGHT_STEP(1,"Right step", new char[]{'d', 'D'}),
    LEFT_STEP(2,"Left step", new char[]{'A', 'a'});

    private final int id;
    private final String label;
    private final char[] validKeys;
    private static final Map<Character, Move> map = new HashMap<>();
    Move(int id, String label, char validKeys[]){
        this.id = id;
        this.label = label;
        this.validKeys = validKeys;
    }
    public int getId(){
        return id;
    }

    static {
        for(Move move : Move.values()){
            for(Character validKey: move.validKeys)
                map.put(validKey, move);
        }
    }

    public static Move getUserInput(Move lastMove){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Dê o seu próximo passo!");
            Character key = input.next().charAt(0);
            Move move = Move.getMove(key);
            if(move == null){
                System.out.println("Entrada inválida.");
                continue;
            }
            if(lastMove == null || move.getId() != lastMove.getId())
                return move;
            System.out.println("Quase caiu, Que isso meu filho, calma!.");
            System.out.println("Lembre-se de usar o outro pé.");
        }
    }

    public static void printAllMoves(){
        for(Move move : Move.values()){
            System.out.println(move);
        }
    }

    @Override
    public String toString(){
        return label+". "+validKeys;
    }

    public static Move getMove(Character key){
        if(map.containsKey(key))
            return map.get(key);
        return null;
    }
    public static boolean isValid(String key){
        if(key.length() > 1 || key.length()==0){
            return false;
        }

        return map.containsKey(key.charAt(0));
    }
}
