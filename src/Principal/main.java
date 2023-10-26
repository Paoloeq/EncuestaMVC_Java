/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.VistaFormulario;
import Vista.VistaResultados;

/**
 *
 * @author Paolo Quispe
 */
public class main {
    public static void main(String[] args) {
        Modelo model = new Modelo();
        VistaFormulario vista = new VistaFormulario();
        VistaResultados vistaresult = new VistaResultados();
        
        Controlador ctrl = new Controlador(model, vista,vistaresult );
        
        ctrl.iniciar();
    }
}
