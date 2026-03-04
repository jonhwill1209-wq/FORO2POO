package service;

import model.Desktop;
import model.Laptop;
import model.Tablet;
import util.InputUtil;

import java.util.ArrayList;

public class EquipoManager {

    private final ArrayList<Desktop> desktops = new ArrayList<>();
    private final ArrayList<Laptop> laptops = new ArrayList<>();
    private final ArrayList<Tablet> tablets = new ArrayList<>();

    public void iniciar() {
        while (true) {
            String opcion = InputUtil.menu(
                    "TODOPC - Menú principal",
                    "Seleccione una opción:",
                    new String[]{"Registrar equipo", "Ver equipos", "Salir"}
            );
            if (opcion == null) return;

            switch (opcion) {
                case "Registrar equipo":
                    registrar();
                    break;
                case "Ver equipos":
                    ver();
                    break;
                case "Salir":
                    return;
            }
        }
    }

    private void registrar() {
        String tipo = InputUtil.menu(
                "Registrar",
                "¿Qué tipo de equipo desea registrar?",
                new String[]{"Desktop", "Laptop", "Tablet", "Volver"}
        );
        if (tipo == null || tipo.equals("Volver")) return;

        switch (tipo) {
            case "Desktop":
                registrarDesktop();
                break;
            case "Laptop":
                registrarLaptop();
                break;
            case "Tablet":
                registrarTablet();
                break;
        }
    }

    private void ver() {
        String tipo = InputUtil.menu(
                "Ver equipos",
                "¿Qué tipo desea ver?",
                new String[]{"Desktop", "Laptop", "Tablet", "Volver"}
        );
        if (tipo == null || tipo.equals("Volver")) return;

        switch (tipo) {
            case "Desktop":
                mostrarListaDesktops();
                break;
            case "Laptop":
                mostrarListaLaptops();
                break;
            case "Tablet":
                mostrarListaTablets();
                break;
        }
    }

    // ===================== REGISTRO =====================

    private void registrarDesktop() {
        String fabricante = InputUtil.pedirNoVacio("Fabricante:");
        if (fabricante == null) return;

        String modelo = InputUtil.pedirNoVacio("Modelo:");
        if (modelo == null) return;

        String micro = InputUtil.pedirNoVacio("Microprocesador:");
        if (micro == null) return;

        String ram = InputUtil.pedirRamTexto(); // ✅ TEXTO
        if (ram == null) return;

        String grafica = InputUtil.pedirNoVacio("Tarjeta gráfica:");
        if (grafica == null) return;

        Integer torre = InputUtil.pedirEnteroPositivo("Tamaño de torre (pulgadas):");
        if (torre == null) return;

        Integer disco = InputUtil.pedirEnteroPositivo("Capacidad de disco duro (GB):");
        if (disco == null) return;

        desktops.add(new Desktop(fabricante, modelo, micro, ram, grafica, torre, disco));
        InputUtil.info("Registro exitoso", "Desktop registrado correctamente ✅");
    }

    private void registrarLaptop() {
        String fabricante = InputUtil.pedirNoVacio("Fabricante:");
        if (fabricante == null) return;

        String modelo = InputUtil.pedirNoVacio("Modelo:");
        if (modelo == null) return;

        String micro = InputUtil.pedirNoVacio("Microprocesador:");
        if (micro == null) return;

        String ram = InputUtil.pedirRamTexto(); // ✅ TEXTO
        if (ram == null) return;

        Double pantalla = InputUtil.pedirDecimalPositivo("Tamaño de pantalla (pulgadas). Ej: 15.6");
        if (pantalla == null) return;

        Integer disco = InputUtil.pedirEnteroPositivo("Capacidad de disco duro (GB):");
        if (disco == null) return;

        laptops.add(new Laptop(fabricante, modelo, micro, ram, pantalla, disco));
        InputUtil.info("Registro exitoso", "Laptop registrada correctamente ✅");
    }

    private void registrarTablet() {
        String fabricante = InputUtil.pedirNoVacio("Fabricante:");
        if (fabricante == null) return;

        String modelo = InputUtil.pedirNoVacio("Modelo:");
        if (modelo == null) return;

        String micro = InputUtil.pedirNoVacio("Microprocesador:");
        if (micro == null) return;

        Double diagonal = InputUtil.pedirDecimalPositivo("Tamaño diagonal de pantalla (pulgadas). Ej: 10.1");
        if (diagonal == null) return;

        String tipoPantalla = InputUtil.menu(
                "Pantalla",
                "Seleccione el tipo de pantalla:",
                new String[]{"Capacitiva", "Resistiva"}
        );
        if (tipoPantalla == null) return;

        Integer nand = InputUtil.pedirEnteroPositivo("Memoria NAND (GB):");
        if (nand == null) return;

        String so = InputUtil.pedirNoVacio("Sistema Operativo:");
        if (so == null) return;

        tablets.add(new Tablet(fabricante, modelo, micro, diagonal, tipoPantalla, nand, so));
        InputUtil.info("Registro exitoso", "Tablet registrada correctamente ✅");
    }

    // ===================== MOSTRAR =====================

    private void mostrarListaDesktops() {
        if (desktops.isEmpty()) {
            InputUtil.info("Desktops", "No hay desktops registrados.");
            return;
        }
        InputUtil.mostrarTextoLargo("Desktops registrados", construirListado(desktops));
    }

    private void mostrarListaLaptops() {
        if (laptops.isEmpty()) {
            InputUtil.info("Laptops", "No hay laptops registradas.");
            return;
        }
        InputUtil.mostrarTextoLargo("Laptops registradas", construirListado(laptops));
    }

    private void mostrarListaTablets() {
        if (tablets.isEmpty()) {
            InputUtil.info("Tablets", "No hay tablets registradas.");
            return;
        }
        InputUtil.mostrarTextoLargo("Tablets registradas", construirListado(tablets));
    }

    private <T> String construirListado(ArrayList<T> lista) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            sb.append("==============================================\n");
            sb.append("Registro #").append(i + 1).append("\n");
            sb.append("----------------------------------------------\n");
            sb.append(lista.get(i).toString()).append("\n");
        }
        sb.append("==============================================\n");
        return sb.toString();
    }
}