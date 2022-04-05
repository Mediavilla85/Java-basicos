/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGUI.ejerciciosDos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.StyledEditorKit;

public class segundoEditor {

    public static void main(String[] args) {
        MarcoPrincipalSegundoEditor marcoPrincipalSegundoEditor = new MarcoPrincipalSegundoEditor();
    }
}

class MarcoPrincipalSegundoEditor extends JFrame {

    public MarcoPrincipalSegundoEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 800, 900);
        add(new LaminaBaseSegundoEditor());

        setVisible(true);

    }
}

class LaminaBaseSegundoEditor extends JPanel {

    private JMenuBar barramenus;
    private JMenu fuentemenu;
    private JMenu estilomenu;
    private JMenu tamanomenu;
    private JTextPane cuadroTexto;
    JPopupMenu menuemergente;
    JToolBar barraHerramientas;

    public LaminaBaseSegundoEditor() {

        setLayout(new BorderLayout());

        //--------AREA TEXTO---------------------//
        cuadroTexto = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(cuadroTexto);

        //--------MENUS-------------------------//
        barramenus = new JMenuBar();
        fuentemenu = new JMenu("Fuente");
        estilomenu = new JMenu("Estilo");
        tamanomenu = new JMenu("Tamaño");

        fuentemenu.add(new StyledEditorKit.FontFamilyAction("Calibri", "Calibri"));
        fuentemenu.add(new StyledEditorKit.FontFamilyAction("Courier New", "Courier New"));
        fuentemenu.add(new StyledEditorKit.FontFamilyAction("Arial", "Arial"));
        fuentemenu.add(new StyledEditorKit.FontFamilyAction("Times new Roman", "Times new Roman"));
        fuentemenu.add(new StyledEditorKit.FontFamilyAction("Verdana", "Verdana"));
        fuentemenu.add(new StyledEditorKit.FontFamilyAction("Comic Sans MS", "Comic Sans MS"));

        JMenuItem negrita = new JMenuItem("Negrita");
        JMenuItem cursiva = new JMenuItem("Cursiva");
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilomenu.add(negrita);
        estilomenu.add(cursiva);

        tamanomenu.add(new StyledEditorKit.FontSizeAction("6", 6));
        tamanomenu.add(new StyledEditorKit.FontSizeAction("8", 8));
        tamanomenu.add(new StyledEditorKit.FontSizeAction("12", 12));
        tamanomenu.add(new StyledEditorKit.FontSizeAction("18", 18));
        tamanomenu.add(new StyledEditorKit.FontSizeAction("24", 24));
        tamanomenu.add(new StyledEditorKit.FontSizeAction("32", 32));

        //--------POPUP-----------------------------//
        menuemergente = new JPopupMenu();

        JMenuItem negritapop = new JMenuItem("Negrita");
        JMenuItem cursivapop = new JMenuItem("Cursiva");
        negritapop.addActionListener(new StyledEditorKit.BoldAction());
        cursivapop.addActionListener(new StyledEditorKit.ItalicAction());

        JMenuItem copiar = new JMenuItem("copiar");
        JMenuItem cortar = new JMenuItem("cortar");
        JMenuItem pegar = new JMenuItem("pegar");

        copiar.addActionListener(new StyledEditorKit.CopyAction());
        cortar.addActionListener(new StyledEditorKit.CutAction());
        pegar.addActionListener(new StyledEditorKit.PasteAction());

        //--------TOOL BAR-----------------------------//
        barraHerramientas = new JToolBar(JToolBar.VERTICAL);

        ComponentesBarraHerramientas verde = new ComponentesBarraHerramientas("verde", new ImageIcon("src/ejerciciosDos/iconos/sphere-green-24 .png"));
        ComponentesBarraHerramientas rojo = new ComponentesBarraHerramientas("rojo", new ImageIcon("src/ejerciciosDos/iconos/sphere-red-24 .png"));
        ComponentesBarraHerramientas azul = new ComponentesBarraHerramientas("azul", new ImageIcon("src/ejerciciosDos/iconos/sphere-blue-24 .png"));
        ComponentesBarraHerramientas justificado = new ComponentesBarraHerramientas("justificado", new ImageIcon("src/ejerciciosDos/iconos/align-justify-24.png"));
        ComponentesBarraHerramientas izquierda = new ComponentesBarraHerramientas("izquierda", new ImageIcon("src/ejerciciosDos/iconos/align-left-24.png"));
        ComponentesBarraHerramientas derecha = new ComponentesBarraHerramientas("derecha", new ImageIcon("src/ejerciciosDos/iconos/align-right-24.png"));
        ComponentesBarraHerramientas centrado = new ComponentesBarraHerramientas("centrado", new ImageIcon("src/ejerciciosDos/iconos/align-center-24.png"));
        ComponentesBarraHerramientas negritaherr = new ComponentesBarraHerramientas("negritaherr", new ImageIcon("src/ejerciciosDos/iconos/bold-24.png"));
        ComponentesBarraHerramientas cursivaherr = new ComponentesBarraHerramientas("cursivaherr", new ImageIcon("src/ejerciciosDos/iconos/italic-24.png"));

        //----------ADD...-----------------------------//
        barraHerramientas.add(azul);
        barraHerramientas.add(rojo);
        barraHerramientas.add(verde);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(justificado);
        barraHerramientas.add(izquierda);
        barraHerramientas.add(derecha);
        barraHerramientas.add(centrado);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(negritaherr);
        barraHerramientas.add(cursivaherr);
        add(barraHerramientas, BorderLayout.WEST);

        menuemergente.add(negritapop);
        menuemergente.add(cursivapop);
        menuemergente.add(copiar);
        menuemergente.add(cortar);
        menuemergente.add(pegar);

        menuemergente.add(fuentemenu);
        menuemergente.add(estilomenu);
        menuemergente.add(tamanomenu);
        barramenus.add(fuentemenu);
        barramenus.add(estilomenu);
        barramenus.add(tamanomenu);
        add(barramenus, BorderLayout.NORTH);

        cuadroTexto.setComponentPopupMenu(menuemergente);

        add(new JPanel(), BorderLayout.SOUTH);

        add(new JPanel(), BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);

    }

    class ComponentesBarraHerramientas extends AbstractAction {

        ActionListener accionoyente;

        public ComponentesBarraHerramientas(String nombre, Icon icono) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if ("verde" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.ForegroundAction("accioncolor", Color.green);
            } else if ("azul" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.ForegroundAction("accioncolor", Color.blue);
            } else if ("rojo" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.ForegroundAction("accioncolor", Color.red);
            } else if ("justificado" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.AlignmentAction(Action.NAME, 0);
            } else if ("izquierda" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.AlignmentAction(Action.NAME, 3);
            } else if ("derecha" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.AlignmentAction(Action.NAME, 2);
            } else if ("centrado" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.AlignmentAction(Action.NAME, 1);
            } else if ("negritaherr" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.BoldAction();
            } else if ("cursivaherr" == getValue(Action.NAME)) {
                accionoyente = new StyledEditorKit.ItalicAction();
            }

            accionoyente.actionPerformed(e);
        }

    }

}

