package com.example.louis.projet2;

import java.util.ArrayList;

public class Question
{
    ArrayList<ArrayList<String>> listeQuestion = new ArrayList<>();
    ArrayList<String> question1 = new ArrayList<>();
    ArrayList<String> question2 = new ArrayList<>();
    ArrayList<String> question3 = new ArrayList<>();
    ArrayList<String> question4 = new ArrayList<>();

    public Question()
    {
        this.question1.add("Quelle est la capitale de la France ?");this.question1.add("Paris");this.question1.add("Angers");this.question1.add("Marseille");this.question1.add("Lyon");
        this.question2.add("Qui est le plus débile ?");this.question1.add("Anthony");this.question1.add("Clément");this.question1.add("Louis");this.question1.add("Jérémy");
        this.question3.add("Il fait chaud ?");this.question1.add("En été");this.question1.add("En autonomne");this.question1.add("En hiver");this.question1.add("Au printemps");
        this.question4.add("L'esaip coûte ?");this.question1.add("Rien du tout");this.question1.add("6000e");this.question1.add("Le rein de Clément");this.question1.add("42");

        this.listeQuestion.add(question1);
        this.listeQuestion.add(question2);
        this.listeQuestion.add(question3);
        this.listeQuestion.add(question4);
    }


    public String getQuestion(int numeroQuestion, int indice)
    {
        return this.listeQuestion.get(numeroQuestion-1).get(indice).toString();
    }

    public boolean checkAnswer(int numeroQuestion, String reponse)
    {
        if(((numeroQuestion == 1) & (reponse == "Paris")) ||
                ((numeroQuestion == 2) & (reponse == "Louis")) ||
                ((numeroQuestion == 3) & (reponse == "En été")) ||
                ((numeroQuestion == 4) & (reponse == "6000e")))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
