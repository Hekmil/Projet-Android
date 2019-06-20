package com.example.louis.projet2;

import java.util.ArrayList;

public class Question
{
    public static int currentQuestion = 1 ;

    ArrayList<ArrayList<String>> listeQuestion = new ArrayList<>();
    ArrayList<String> question1 = new ArrayList<>();
    ArrayList<String> question2 = new ArrayList<>();
    ArrayList<String> question3 = new ArrayList<>();
    ArrayList<String> question4 = new ArrayList<>();
    ArrayList<String> question5 = new ArrayList<>();
    ArrayList<String> question6 = new ArrayList<>();
    ArrayList<String> question7 = new ArrayList<>();
    ArrayList<String> question8 = new ArrayList<>();
    ArrayList<String> question9 = new ArrayList<>();
    ArrayList<String> question10 = new ArrayList<>();

    public Question()
    {
        this.question1.add("Que trouve-ton dans la plupart des jardins ?");this.question1.add("Des tuyaux d'affichage");this.question1.add("Des tuyaux d'allumage");this.question1.add("Des tuyaux d'atterissage");this.question1.add("Des tuyaux d'arrosage");
        this.question2.add("A noel, les santons entouraient l'enfant Jésus dans... ");this.question2.add("La hutte");this.question2.add("La crèche");this.question2.add("La cachette");this.question2.add("Le tipi");
        this.question3.add("Aux Etats-Unis, Hollywood est une ville dédiée à l'industrie...");this.question3.add("De la chaussure");this.question3.add("Cinématographique");this.question3.add("De la pizza");this.question3.add("Automobile");
        this.question4.add("Laquelle de ces propositions désigne un coquillage comestible ?");this.question4.add("Bigoudi");this.question4.add("Boléro");this.question4.add("Biguine");this.question4.add("Bigorneau");
        this.question5.add("Rond ou ovale, le bijou dans lequel on enferme un portrait est...");this.question5.add("Une gourmette");this.question5.add("Un diadème");this.question5.add("Une chevalière");this.question5.add("Un médaillon");
        this.question6.add("Où fait-on pousser de jeunes arbres destinés à être transplantés ?");this.question6.add("Dans un verger");this.question6.add("Dans un potager");this.question6.add("Dans une jardinière");this.question6.add("Dans une pépinière");
        this.question7.add("Comment appelle-t-on l'enveloppe de la Terre située entre la croûte et le noyau ?");this.question7.add("Le chemisier");this.question7.add("Le manteau");this.question7.add("La tunique");this.question7.add("La camisole");
        this.question8.add("Un requiem est une musique composée pour ...");this.question8.add("Célébrer des fiançailles");this.question8.add("La messe des morts");this.question8.add("Célébrer une naissance");this.question8.add("La messe de mariage");
        this.question9.add("Chacune des grosses artères qui conduisent le sang vers la tête est une ...");this.question9.add("Aorte");this.question9.add("Cariatide");this.question9.add("Carotide");this.question9.add("Synapse");
        this.question10.add("Quelle est la religion majoritaire de l'indonésie ?");this.question10.add("Le boudhisme");this.question10.add("Le christianisme");this.question10.add("L'hindouisme");this.question10.add("L'islam");

        this.listeQuestion.add(question1);
        this.listeQuestion.add(question2);
        this.listeQuestion.add(question3);
        this.listeQuestion.add(question4);
        this.listeQuestion.add(question5);
        this.listeQuestion.add(question6);
        this.listeQuestion.add(question7);
        this.listeQuestion.add(question8);
        this.listeQuestion.add(question9);
        this.listeQuestion.add(question10);

    }

    public int getCurrentQuestion()
    {
        return this.currentQuestion;
    }


    public String getQuestion(int numeroQuestion, int indice)
    {
        return this.listeQuestion.get(numeroQuestion-1).get(indice).toString();
    }

    public boolean checkAnswer(int numeroQuestion, String reponse)
    {
        if(((numeroQuestion == 1) & (reponse == "Des tuyaux d'arrosage")) ||
                ((numeroQuestion == 2) & (reponse == "La crèche")) ||
                ((numeroQuestion == 3) & (reponse == "Cinématographique" )) ||
                ((numeroQuestion == 4) & (reponse =="Bigorneau" )) ||
                ((numeroQuestion == 5) & (reponse =="Un médaillon" )) ||
                ((numeroQuestion == 6) & (reponse =="Dans une pépinière" )) ||
                ((numeroQuestion == 7) & (reponse =="Le manteau" )) ||
                ((numeroQuestion == 8) & (reponse =="La messe des morts" )) ||
                ((numeroQuestion == 9) & (reponse =="Carotide" )) ||
                ((numeroQuestion == 10) & (reponse == "L'islam")))

        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
