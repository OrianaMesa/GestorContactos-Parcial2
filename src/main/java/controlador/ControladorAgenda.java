/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Agenda;
import modelo.Contacto;
/**
 *
 * @author oriana
 */
public class ControladorAgenda {
    
    private Agenda agenda;
    public ControladorAgenda() {
        agenda = new Agenda();
    }

    public boolean guardarContacto(String nombre, String telefono) {
        return agenda.guardarContacto(nombre, telefono);
    }

    public Contacto buscarContacto(String nombre) {
        return agenda.buscarContacto(nombre);
    }
}
