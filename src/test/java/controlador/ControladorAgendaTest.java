/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Contacto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author orian
 */
public class ControladorAgendaTest {
    @Test
    public void guardarContactoValido() {
        ControladorAgenda controlador = new ControladorAgenda();

        assertTrue(controlador.guardarContacto("Sofia", "3063098750"));
    }
    
    @Test
    public void guardarConCamposVacios() {
        ControladorAgenda controlador = new ControladorAgenda();

        assertFalse(controlador.guardarContacto("", "3063098750"));
        assertFalse(controlador.guardarContacto("Sofia", ""));
    }
    
    @Test
    public void noPermiteGuardarNombreRepetido() {
        ControladorAgenda controlador = new ControladorAgenda();
        controlador.guardarContacto("Sofia", "3063098750");

        assertFalse(controlador.guardarContacto("Sofia", "3000000000"));
    }
    
    @Test
    public void buscarContactoExistenteDevuelveElContacto() {
        ControladorAgenda controlador = new ControladorAgenda();
        controlador.guardarContacto("Sofia", "3063098750");

        Contacto contacto = controlador.buscarContacto("Sofia");

        assertNotNull(contacto);
        assertEquals("3063098750", contacto.getTelefono());
    }
    
    @Test
    public void buscarContactoIgnoraMayusculas() {
        ControladorAgenda controlador = new ControladorAgenda();
        controlador.guardarContacto("Alberto", "3109876543");

        Contacto contacto = controlador.buscarContacto("alberto");

        assertNotNull(contacto);
        assertEquals("Alberto", contacto.getNombre());
    }

    @Test
    public void buscarContactoInexistente() {
        ControladorAgenda controlador = new ControladorAgenda();

        assertNull(controlador.buscarContacto("Pedro"));
    }
}
