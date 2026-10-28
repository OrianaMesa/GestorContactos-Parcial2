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
public class ContactoTest {
    @Test
    public void constructorGuardaElNombre() {
        Contacto contacto = new Contacto("Sofia", "3063098750");

        assertEquals("Sofia", contacto.getNombre());
    }
    
    @Test
    public void constructorGuardaElTelefono() {
        Contacto contacto = new Contacto("Sofia", "3063098750");

        assertEquals("3063098750", contacto.getTelefono());
    }
    
    @Test
    public void telefonoConservaCerosYSignos() {
        Contacto contacto = new Contacto("Alberto", "+57 0310");

        assertEquals("+57 0310", contacto.getTelefono());
    }
    
}
