package model;

public class Desktop extends Equipo {
    private final String ram;             // Ej: "32 GB DDR5"
    private final String tarjetaGrafica;
    private final int tamanoTorrePulg;
    private final int discoGB;

    public Desktop(String fabricante, String modelo, String microprocesador,
                   String ram, String tarjetaGrafica, int tamanoTorrePulg, int discoGB) {
        super(fabricante, modelo, microprocesador);
        this.ram = ram;
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorrePulg = tamanoTorrePulg;
        this.discoGB = discoGB;
    }

    public String getRam() { return ram; }
    public String getTarjetaGrafica() { return tarjetaGrafica; }
    public int getTamanoTorrePulg() { return tamanoTorrePulg; }
    public int getDiscoGB() { return discoGB; }

    @Override
    public String toString() {
        return  "🖥️  DESKTOP\n" +
                infoBasica() +
                "RAM             : " + ram + "\n" +
                "Tarjeta gráfica : " + tarjetaGrafica + "\n" +
                "Torre           : " + tamanoTorrePulg + " pulgadas\n" +
                "Disco duro      : " + discoGB + " GB\n";
    }
}