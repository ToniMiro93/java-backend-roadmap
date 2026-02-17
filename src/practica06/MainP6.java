package practica06;

import java.util.List;
import java.util.Scanner;

public class MainP6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactService agenda = new ContactService();

        while(true){
            System.out.println("--- ContactManager ---");
            System.out.println("1) Crear contacto");
            System.out.println("2) Listar contactos");
            System.out.println("3) Buscar por id");
            System.out.println("4) Borrar contacto");
            System.out.println("5) Editar contacto");
            System.out.println("6) Salir");
            System.out.print("Elige una opción: ");


            String opcion= sc.nextLine().trim();
            switch (opcion){
                case "1" -> {
                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Introduce el telefono: ");
                    String telefono = sc.nextLine().trim();
                    System.out.println("Contacto creado ->" + agenda.crearContacto(nombre,telefono).toString());
                }
                case "2" -> {
                    List<Contact> contactos = agenda.listar();
                    if (contactos.isEmpty()){
                        System.out.println("No hay contactos creados");
                    }else{
                        contactos.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("Introduce el id del contacto: ");
                    int id = leerEntero(sc);
                    if (id == -1) continue;
                    try {
                        System.out.println(agenda.buscarContacto(id).toString());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "4" -> {
                    System.out.print("Introduce el id del contacto: ");
                    int id = leerEntero(sc);
                    if (id == -1) continue;
                    boolean ok = agenda.borrarContacto(id);
                    System.out.println(ok? "Contacto borrado":"No existe ese contacto");
                }
                case "5" -> {
                    System.out.print("Introduce el id del contacto: ");
                    int id = leerEntero(sc);
                    if (id == -1) continue;
                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Introduce el telefono: ");
                    String telefono = sc.nextLine().trim();
                    boolean ok = agenda.editarContacto(id,nombre,telefono);
                    System.out.println(ok ? "Contacto editado" : "El contacto no existe");
                }
                case "6" -> {
                    System.out.print("Saliendo... ");
                    return;
                }
                default -> System.out.println("Opción invalida");

            }
        }
    }
    private static int leerEntero(Scanner sc){
        String s = sc.nextLine().trim();
        try{
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println("Debes introducir un numero.");
            return -1;
        }
    }
}
