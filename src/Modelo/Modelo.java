/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author LAB-USR-CHIM-A0208
 */
public class Modelo {
    
    private int numPregunta;
    
    private String[][] preguntasVector = new String[3][1];
    private String[][] alternativasVector = new String[3][4];
    private String[][] respuestasVector = new String[3][1];
    
    private int numPreguntasCorrectas;
    private int numPreguntasIncorrectas;
    private int numPreguntasSinContestar;

    //constructor 
    public Modelo(int numPregunta, int numPreguntasCorrectas, int numPreguntasIncorrectas, int numPreguntasSinContestar) {
        this.numPregunta = numPregunta;
        this.numPreguntasCorrectas = numPreguntasCorrectas;
        this.numPreguntasIncorrectas = numPreguntasIncorrectas;
        this.numPreguntasSinContestar = numPreguntasSinContestar;
    }

    public Modelo() {
    }

    //metodos del negocio
    public int totalPuntaje(){
        return numPreguntasCorrectas*2;
    }
    
    
    //colocar preguntas alternativas y respuestas, ESTO ES LO QUE VA ESTAR CAMBIANDO SEGUN SE LA ENCUESTA
    public void colocarPreguntasAlternativasRespuestas(){
        preguntasVector[0][0]="1. \"W es 15 unidades mayor Y\" escrito para solucionar un problema sería:";
        preguntasVector[1][0]="2. AL resolver la ecuación 8x-(3x+7) =18 se obtiene para x:";
        preguntasVector[2][0]="3. Tenemos que 15 es el radio de un circulo";
        
        //alternativas pregunta 1
        alternativasVector[0][0]="w+15";
        alternativasVector[0][1]="y+15";
        alternativasVector[0][2]="y-15";
        alternativasVector[0][3]="15*w";
        
        //alternativas pregunta 2
        alternativasVector[1][0]="-5";
        alternativasVector[1][1]="11/5";
        alternativasVector[1][2]="5/11";
        alternativasVector[1][3]="5";
        
        //alternativas pregunta 3
        alternativasVector[2][0]="150";
        alternativasVector[2][1]="50";
        alternativasVector[2][2]="75";
        alternativasVector[2][3]="N.A.";
        
        
        //Respuestas 
        respuestasVector[0][0]="w+15";//Respuest primera pregunta
        respuestasVector[1][0]="5/11";//Respuest segunda pregunta
        respuestasVector[2][0]="50";//Respuest tercera pregunta
        
    }
    
        
    //get and setters

    public int getNumPregunta() {
        return numPregunta;
    }

    public void setNumPregunta(int numPregunta) {
        this.numPregunta = numPregunta;
    }

    public int getNumPreguntasCorrectas() {
        return numPreguntasCorrectas;
    }

    public void setNumPreguntasCorrectas(int numPreguntasCorrectas) {
        this.numPreguntasCorrectas = numPreguntasCorrectas;
    }

    public int getNumPreguntasIncorrectas() {
        return numPreguntasIncorrectas;
    }

    public void setNumPreguntasIncorrectas(int numPreguntasIncorrectas) {
        this.numPreguntasIncorrectas = numPreguntasIncorrectas;
    }

    public int getNumPreguntasSinContestar() {
        return numPreguntasSinContestar;
    }

    public void setNumPreguntasSinContestar(int numPreguntasSinContestar) {
        this.numPreguntasSinContestar = numPreguntasSinContestar;
    }

    public String getPreguntasVector(int a, int b) {
        return preguntasVector[a][b];
    }

    public void setPreguntasVector(String[][] preguntasVector) {
        this.preguntasVector = preguntasVector;
    }

    public String getAlternativasVector(int a, int b) {
        return alternativasVector[a][b];
    }

    public void setAlternativasVector(String[][] alternativasVector) {
        this.alternativasVector = alternativasVector;
    }

    public String getRespuestasVector(int a, int b) {
        return respuestasVector[a][b];
    }

    public void setRespuestasVector(String[][] respuestasVector) {
        this.respuestasVector = respuestasVector;
    }
    
    
    
}
