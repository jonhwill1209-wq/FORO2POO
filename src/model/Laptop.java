package model;

public class Laptop extends Equipo {
    private final String ram;         // Ej: "16 GB DDR4"
    private final double pantallaPulg;
    private final int discoGB;

    public Laptop(String fabricante, String modelo, String microprocesador,
                  String ram, double pantallaPulg, int discoGB) {
        super(fabricante, modelo, microprocesador);
        this.ram = ram;
        this.pantallaPulg = pantallaPulg;
        this.discoGB = discoGB;
    }

    public String getRam() { return ram; }
    public double getPantallaPulg() { return pantallaPulg; }
    public int getDiscoGB() { return discoGB; }

    @Override
    public String toString() {
        return  "💻  LAPTOP\n" +
                infoBasica() +
                "RAM             : " + ram + "\n" +
                "Pantalla        : " + pantallaPulg + " pulgadas\n" +
                "Disco duro      : " + discoGB + " GB\n";
    }
}