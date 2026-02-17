package practica06;

public class Contact {
    private final int id;
    private String nombre;
    private String telefono;

    public Contact(int id, String nombre, String telefono){
        this.id = id;
        setNombre(nombre);
        setTelefono(telefono); ;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return  nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("EL nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("EL teléfono no puede estar vacío.");
        }
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return String.format("[#%d] %s - %s", id, nombre, telefono);
    }
}
