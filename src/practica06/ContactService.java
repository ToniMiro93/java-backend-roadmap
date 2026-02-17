package practica06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactService {
    private final List<Contact> contactos= new ArrayList<>();
    private int siguienteId = 1;

    public Contact crearContacto(String nombre, String telefono){
        Contact contacto= new Contact(siguienteId++, nombre, telefono);
        contactos.add(contacto);
        return contacto;
    }

    public List<Contact> listar(){
        return new ArrayList<>(contactos);
    }

    public boolean borrarContacto(int id){
        return contactos.removeIf(c -> c.getId() == id);
    }

    public boolean editarContacto(int id, String nombre, String telefono){
        Optional<Contact> opt = buscarPorId(id);
        if (opt.isEmpty()) return false;
        opt.get().setNombre(nombre);
        opt.get().setTelefono(telefono);
        return true;
    }
    public Contact buscarContacto (int id){
        return buscarPorId(id).orElseThrow(()-> new RuntimeException("El contacto no existe"));
    }

    private Optional<Contact> buscarPorId(int id){
        for (Contact c : contactos) {
            if (c.getId() == id) return Optional.of(c);
        }
        return Optional.empty();
    }
}
