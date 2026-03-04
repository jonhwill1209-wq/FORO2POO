package model;

public class Tablet extends Equipo {

    private final double diagonalPulg;
    private final String tipoPantalla;   // Capacitiva/Resistiva
    private final int nandGB;
    private final String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador,
                  double diagonalPulg, String tipoPantalla, int nandGB, String sistemaOperativo) {

        super(fabricante, modelo, microprocesador);
        this.diagonalPulg = diagonalPulg;
        this.tipoPantalla = tipoPantalla;
        this.nandGB = nandGB;
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getDiagonalPulg() { return diagonalPulg; }
    public String getTipoPantalla() { return tipoPantalla; }
    public int getNandGB() { return nandGB; }
    public String getSistemaOperativo() { return sistemaOperativo; }

    @Override
    public String toString() {
        return  "📱  TABLET\n" +
                infoBasica() +
                "Diagonal        : " + diagonalPulg + " pulgadas\n" +
                "Pantalla        : " + tipoPantalla + "\n" +
                "Memoria NAND    : " + nandGB + " GB\n" +
                "Sistema Oper.   : " + sistemaOperativo + "\n";
    }
}