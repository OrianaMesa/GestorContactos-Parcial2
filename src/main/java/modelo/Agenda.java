/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author oriana
 */
public class Agenda {
    private Contacto[] contactos;
    private int cantidad;

    public Agenda() {
        contactos = new Contacto[100];
        cantidad = 0;
    }

    public boolean guardarContacto(String nombre, String telefono) {

        if (nombre.isEmpty() || telefono.isEmpty()) {
            return false;
        }

        if (cantidad >= contactos.length) {
            return false;
        }

        if (buscarContacto(nombre) != null) {
            return false;
        }

        Contacto contacto = new Contacto(nombre, telefono);

        contactos[cantidad] = contacto;
        cantidad++;

        return true;
    }

    public Contacto buscarContacto(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return contactos[i];
            }
        }

        return null;
    }
}
