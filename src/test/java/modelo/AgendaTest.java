/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author orian
 */
public class AgendaTest {
    @Test
    public void testguardarContacto (){
    Agenda agenda = new Agenda();
    
    assertTrue(agenda.guardarContacto("Sofia", "3063098750"));
    }
    
     @Test
    public void guardarConNombre() {
        Agenda agenda = new Agenda();

        assertFalse(agenda.guardarContacto("", "3063098750"));
    }

    @Test
    public void guardarConTelefonoVacio() {
        Agenda agenda = new Agenda();

        assertFalse(agenda.guardarContacto("Sofia", ""));
    }

    @Test
    public void guardarNombreRepetido() {
        Agenda agenda = new Agenda();
        agenda.guardarContacto("Sofia", "3063098750");

        assertFalse(agenda.guardarContacto("Sofia", "300234564"));
    }

    @Test
    public void guardarNombreRepetidoSinImportarMayusculas() {
        Agenda agenda = new Agenda();
        agenda.guardarContacto("Sofia", "3063098750");

        assertFalse(agenda.guardarContacto("SOFIA", "3000000000"));
    }

    @Test
    public void guardarConAgendaLlena() {
        Agenda agenda = new Agenda();

        for (int i = 0; i < 100; i++) {
            assertTrue(agenda.guardarContacto("Contacto" + i, "300" + i));
        }

        assertFalse(agenda.guardarContacto("Contacto100", "3009999999"));
    }

    @Test
    public void buscarContactoExistenteDevuelveElContacto() {
        Agenda agenda = new Agenda();
        agenda.guardarContacto("Sofia", "3063098750");

        Contacto contacto = agenda.buscarContacto("Sofia");

        assertNotNull(contacto);
        assertEquals("Sofia", contacto.getNombre());
        assertEquals("3063098750", contacto.getTelefono());
    }

    @Test
    public void buscarContactoIgnoraMayusculas() {
        Agenda agenda = new Agenda();
        agenda.guardarContacto("Alberto", "3109876543");

        Contacto contacto = agenda.buscarContacto("alberto");

        assertNotNull(contacto);
        assertEquals("3109876543", contacto.getTelefono());
    }

    @Test
    public void buscarContactoInexistenteDevuelveNull() {
        Agenda agenda = new Agenda();
        agenda.guardarContacto("Sofia", "3063098750");

        assertNull(agenda.buscarContacto("Pedro"));
    }
}
