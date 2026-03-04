package util;

import javax.swing.*;
import java.awt.*;

public class InputUtil {

    private static final String TITULO_APP = "TODOPC - Inventario";
    private static final Icon ICON_INFO = UIManager.getIcon("OptionPane.informationIcon");
    private static final Icon ICON_WARN = UIManager.getIcon("OptionPane.warningIcon");
    private static final Icon ICON_QUESTION = UIManager.getIcon("OptionPane.questionIcon");

    // Menú bonito (botones)
    public static String menu(String titulo, String mensaje, String[] opciones) {
        Object sel = JOptionPane.showOptionDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                ICON_QUESTION,
                opciones,
                opciones[0]
        );
        if (sel == null) return null;
        int idx = (int) sel;
        if (idx < 0 || idx >= opciones.length) return null;
        return opciones[idx];
    }

    // Entrada no vacía
    public static String pedirNoVacio(String etiqueta) {
        while (true) {
            String dato = JOptionPane.showInputDialog(
                    null,
                    etiqueta,
                    TITULO_APP,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dato == null) return null;
            dato = dato.trim();
            if (!dato.isEmpty()) return dato;
            warn("Validación", "El campo no puede quedar vacío:\n" + etiqueta);
        }
    }

    // RAM como texto (no vacía) + guía visual
    public static String pedirRamTexto() {
        while (true) {
            String dato = JOptionPane.showInputDialog(
                    null,
                    "RAM (escribe cantidad + tipo)\nEjemplos: 16 GB DDR4 | 32GB DDR5 | 8 GB LPDDR5",
                    TITULO_APP,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dato == null) return null;
            dato = dato.trim();
            if (dato.isEmpty()) {
                warn("Validación", "La RAM no puede quedar vacía.");
                continue;
            }
            // Validación ligera: que tenga al menos un número
            if (!dato.matches(".*\\d+.*")) {
                warn("Validación", "La RAM debe incluir al menos un número.\nEj: 16 GB DDR4");
                continue;
            }
            return dato;
        }
    }

    // Entero positivo con try/catch
    public static Integer pedirEnteroPositivo(String etiqueta) {
        while (true) {
            String dato = JOptionPane.showInputDialog(
                    null,
                    etiqueta,
                    TITULO_APP,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dato == null) return null;
            dato = dato.trim();
            if (dato.isEmpty()) {
                warn("Validación", "No puede quedar vacío:\n" + etiqueta);
                continue;
            }
            try {
                int n = Integer.parseInt(dato);
                if (n <= 0) {
                    warn("Validación", "Debe ser un número mayor a 0.");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                warn("Validación", "Ingrese un número entero válido.");
            }
        }
    }

    // Decimal positivo
    public static Double pedirDecimalPositivo(String etiqueta) {
        while (true) {
            String dato = JOptionPane.showInputDialog(
                    null,
                    etiqueta,
                    TITULO_APP,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dato == null) return null;
            dato = dato.trim();
            if (dato.isEmpty()) {
                warn("Validación", "No puede quedar vacío:\n" + etiqueta);
                continue;
            }
            try {
                double n = Double.parseDouble(dato);
                if (n <= 0) {
                    warn("Validación", "Debe ser un número mayor a 0.");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                warn("Validación", "Ingrese un número válido (puede ser decimal).");
            }
        }
    }

    public static void info(String titulo, String msg) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE, ICON_INFO);
    }

    public static void warn(String titulo, String msg) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.WARNING_MESSAGE, ICON_WARN);
    }

    // Mostrar listas largas con scroll
    public static void mostrarTextoLargo(String titulo, String contenido) {
        JTextArea area = new JTextArea(contenido, 18, 55);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, scroll, titulo, JOptionPane.INFORMATION_MESSAGE, ICON_INFO);
    }
}