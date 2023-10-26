/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo;
import Vista.VistaFormulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaResultados;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB-USR-CHIM-A0208
 */
public class Controlador implements ActionListener{
    private Modelo model;
    private VistaFormulario viewForm;
    private VistaResultados viewResult;

    //constructor
    public Controlador(Modelo model, VistaFormulario viewForm, VistaResultados viewResult) {
        this.model = model;
        this.viewForm = viewForm;
        this.viewResult = viewResult;
        this.viewForm.btnSiguente.addActionListener(this);
        
    }
    
    //función para inciar el programa
    public void iniciar(){
        viewForm.setTitle("Formulario");
        viewForm.setLocationRelativeTo(null);
        viewForm.setVisible(true);
        
        //put the questions, answer in the model
        model.colocarPreguntasAlternativasRespuestas();
        
        //preguntas ponerlas en la vista
        viewForm.lblPregunta1.setText(model.getPreguntasVector(0,0));
        viewForm.lblPregunta2.setText(model.getPreguntasVector(1,0));
        viewForm.lblPregunta3.setText(model.getPreguntasVector(2,0));
        
        //alternativas ponerlas en la vista
        viewForm.alter1_1.setText(model.getAlternativasVector(0,0));
        viewForm.alter1_2.setText(model.getAlternativasVector(0, 1));
        viewForm.alter1_3.setText(model.getAlternativasVector(0,2));
        viewForm.alter1_4.setText(model.getAlternativasVector(0, 3));
        
        viewForm.alter2_1.setText(model.getAlternativasVector(1,0));
        viewForm.alter2_2.setText(model.getAlternativasVector(1, 1));
        viewForm.alter2_3.setText(model.getAlternativasVector(1,2));
        viewForm.alter2_4.setText(model.getAlternativasVector(1, 3));
        
        viewForm.alter3_1.setText(model.getAlternativasVector(2,0));
        viewForm.alter3_2.setText(model.getAlternativasVector(2, 1));
        viewForm.alter3_3.setText(model.getAlternativasVector(2,2));
        viewForm.alter3_4.setText(model.getAlternativasVector(2, 3));
        
    }
    
    //Actión del  boton siguiente
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ("".equals(viewForm.txtNombreAlumno.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese su nombre");
        }else{
        
            int numeroDeCorrectas=0;
            int numeroDeIncorrectas=0;
            int numeroDeVacios=0;

            //Identifica las correctas, incorrectas y vacias segun las vistas
            if(isAnyButtonSelected(viewForm.buttonGroup1)){

                if (returnValueButton(viewForm.buttonGroup1).equals(model.getRespuestasVector(0,0))) {
                numeroDeCorrectas=numeroDeCorrectas+1;

            }else{
                numeroDeIncorrectas=numeroDeIncorrectas+1;
                }
            }else{
                numeroDeVacios=numeroDeVacios+1;
            }

            if(isAnyButtonSelected(viewForm.buttonGroup2)){
                if (returnValueButton(viewForm.buttonGroup2).equals(model.getRespuestasVector(1,0))) {
                numeroDeCorrectas=numeroDeCorrectas+1;
            }else{
                numeroDeIncorrectas=numeroDeIncorrectas+1;
                }
            }else{
                numeroDeVacios=numeroDeVacios+1;
            }


            if(isAnyButtonSelected(viewForm.buttonGroup3)){
                if (returnValueButton(viewForm.buttonGroup3).equals(model.getRespuestasVector(2,0))) {
                numeroDeCorrectas=numeroDeCorrectas+1;
            }else{
                numeroDeIncorrectas=numeroDeIncorrectas+1;
                }
            }else{
                numeroDeVacios=numeroDeVacios+1;
            }

            //se coloca en el modelo los valores de las correctas, incorrectas y vacios
            model.setNumPreguntasSinContestar(numeroDeVacios);
            model.setNumPreguntasIncorrectas(numeroDeIncorrectas);
            model.setNumPreguntasCorrectas(numeroDeCorrectas);

            //abre ventana resultados
            viewResult.setTitle("Resultados de la encuesta");
            viewResult.setLocationRelativeTo(null);
            viewResult.setVisible(true);

            //obtener el nombre y colcarlo en la venta resultados
            viewResult.lblNombreAlumno.setText(viewForm.txtNombreAlumno.getText());

            //se coloca en la vista resultados los valores anteriores
            viewResult.lblCorrectasNum.setText(model.getNumPreguntasCorrectas()+"");
            viewResult.lblIncorrectasNum.setText(model.getNumPreguntasIncorrectas()+"");
            viewResult.lblSinContestarNum.setText(model.getNumPreguntasSinContestar()+"");

            //Mostrar el puntaje
            viewResult.lblPuntajeNum.setText(model.totalPuntaje()+"");
        
        }
    }

    //función para return true or false si el button group está seleccionado alguno de los botones o no.
    private boolean isAnyButtonSelected(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return true;
            }
        }
        return false;
    }
    
    //funcion para obtener valor (string) de jradiobutton marcado en unjbuttongroup
    private String returnValueButton(ButtonGroup buttonGroup){
        String selection = "";
        for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if(button.isSelected()){
                selection = button.getText();
                break;
            }
        } 
        return selection;
    }
    
}
