package operaciones;

import static ventanas.GuiSimplex.jtaOperaciones;
import javax.swing.table.DefaultTableModel;

public class GetX {

    private static int filaX;

    public static void mostar(DefaultTableModel modeloSolucion, int Xn) {
        int fil = modeloSolucion.getRowCount();
        int col = modeloSolucion.getColumnCount();
        jtaOperaciones.setText("Aquí tenemos la solución Paso a Paso\n\n");
        String xn;
        for (int n = 1; n <= Xn; n++) {
            xn = "X" + n;
            if (estaXn(modeloSolucion, xn, fil, col)) {
                jtaOperaciones.append("1. " + xn + " = " + AproximarNumero.valorAprocimado(String.valueOf(modeloSolucion.getValueAt(filaX, col - 2))) + "\n");
            } else {
                jtaOperaciones.append("2. " + xn + " = 0" + "\n");
            }
        }
        jtaOperaciones.append("\n3. Z = " + String.valueOf(modeloSolucion.getValueAt(fil - 2, col - 2)));
    }

    private static boolean estaXn(DefaultTableModel modeloSolucion, String xn, int fil, int col) {
        String x;
        for (int f = 2; f < fil - 2; f++) {
            x = String.valueOf(modeloSolucion.getValueAt(f, col - 3));
            if (x.equalsIgnoreCase(xn)) {
                filaX = f;
                return true;
            }
        }
        return false;
    }
}