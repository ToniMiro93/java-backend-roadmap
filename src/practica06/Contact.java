package practica06;

public class Contact {
    private final int id;
    private String nombre;
    private String telefono;

    public Contact(int id, String nombre, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
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
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return String.format("[#%d] %s - %s", id, nombre, telefono);
    }
}
