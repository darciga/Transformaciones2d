package unidad2;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.net.*; //URL

class RatonListener extends MouseAdapter {

	Principal T;

	public RatonListener(Principal t) {
		T = t;
	}

	public void mouseClicked(MouseEvent me) {
		int nclicks = me.getClickCount();
		if (nclicks >= 2) {
			int rx = me.getX();
			T.F.encminmax();
			if (rx > T.F.maxx) {
				T.F.rotar_cp(5);
			} else if (rx < T.F.minx) {
				T.F.rotar_sp(5);
			}
		}
		T.repaint();
	}

	public void mousePressed(MouseEvent me) {
		int rx = me.getX();
		int ry = me.getY();
		T.F.encminmax();
		if (rx > T.F.minx && rx < T.F.maxx && ry > T.F.miny && ry < T.F.maxy) {
			T.mover = true;
		} else {
			T.mover = false;
		}
	}
}

class Arrastre extends MouseMotionAdapter {

	Principal T;

	public Arrastre(Principal t) {
		T = t;
	}

	public void mouseDragged(MouseEvent me) {
		if (T.mover) {
			int rx = me.getX();
			int ry = me.getY();
			double atx = 0, aty = 0;
			double px = T.F.fig[0][0];
			double py = T.F.fig[0][1];
			double difx = rx - px;
			double dify = ry - py;
			if (rx > T.max || ry > T.may || rx < T.mix || ry < T.miy) {
				T.F.Trasladar(atx, aty);
			} else {

				T.F.Trasladar(difx, dify);
				atx = difx;
				aty = dify;
			}
		}
		T.repaint();
	}
}

public class Principal extends JPanel implements ActionListener,
		MouseWheelListener {

	JFrame vent;
	boolean mover = false;
	int e = 0;
	Container cont;
	Button Bdib, Besc, Bdef, Brotc, Brots, Btras, Bref;
	Figura F;
	// menu
	JPopupMenu popup;
	JMenuBar BarraM;
	JMenu Inicio,Trans, Acerca;
	JMenuItem Escalar, Restaurar, Rotarc, Rotars, Reflexion, Deformar, Trasladar;
	JMenuItem Salir, Autor, Ayuda, Version;
	// Barra de Herramientas
	JToolBar BarraH;
	// Valores maximos
	int max = 0, may = 0, mix = 0, miy = 0;
	double emx = 2.2, emy = 2.2;

	public Principal(String Tit, double fig[][], double t1[][],
			double t2[][], double t3[][], double t4[][], double t5[][]) {
		vent = new JFrame(Tit);
		cont = vent.getContentPane();
		vent.setSize(900, 700);
		this.setSize(900, 700);
		vent.setResizable(false);
		BarraM = new JMenuBar();
		vent.setJMenuBar(BarraM);
		Inicio = new JMenu("Inicio");
		Trans = new JMenu("Transformaciones");
		Acerca = new JMenu("Acerca De");
		BarraM.add(Inicio);
		BarraM.add(Trans);
		BarraM.add(Acerca);
		
		Restaurar = new JMenuItem("Restaurar");
		Restaurar.setMnemonic('D');
		Restaurar.setToolTipText("Restaura la figura a las coordenadas originales");
		URL rutad = getClass().getResource("rec/restaurar.png");
		Restaurar.setIcon(new ImageIcon(rutad));
		Restaurar.addActionListener(this);
		Inicio.add(Restaurar);

		Escalar = new JMenuItem("Escalar");
		Escalar.setMnemonic('E');
		Escalar.setToolTipText("Escala la figura mostrada");
		rutad = getClass().getResource("rec/escalar.png");
		Escalar.setIcon(new ImageIcon(rutad));
		Escalar.addActionListener(this);
		Trans.add(Escalar);

		Deformar = new JMenuItem("Deformar");
		Deformar.setMnemonic('f');
		Deformar.setToolTipText("Deforma la figura mostrada");
		rutad = getClass().getResource("rec/deformar.png");
		Deformar.setIcon(new ImageIcon(rutad));
		Deformar.addActionListener(this);
		Trans.add(Deformar);

		Rotarc = new JMenuItem("Rotar en Contra");
		Rotarc.setMnemonic('C');
		Rotarc.setToolTipText("Rota la figura en contra de la manecillas del reloj");
		rutad = getClass().getResource("rec/rotarcontra.png");
		Rotarc.setIcon(new ImageIcon(rutad));
		Rotarc.addActionListener(this);
		Trans.add(Rotarc);

		Rotars = new JMenuItem("Rotar en el Sentido");
		Rotars.setMnemonic('S');
		Rotars.setToolTipText("Rota la figura en el sentido de las manecillas del reloj");
		rutad = getClass().getResource("rec/rotarsen.png");
		Rotars.setIcon(new ImageIcon(rutad));
		Rotars.addActionListener(this);
		Trans.add(Rotars);

		Trasladar = new JMenuItem("Trasladar");
		Trasladar.setMnemonic('T');
		Trasladar.setToolTipText("Traslada la figura mostrada");
		rutad = getClass().getResource("rec/trasladar.png");
		Trasladar.setIcon(new ImageIcon(rutad));
		Trasladar.addActionListener(this);
		Trans.add(Trasladar);

		Reflexion = new JMenuItem("Refleja la figura");
		Reflexion.setMnemonic('R');
		Reflexion
				.setToolTipText("Rota la figura en el sentido de las manecillas del reloj");
		rutad = getClass().getResource("rec/refle.png");
		Reflexion.setIcon(new ImageIcon(rutad));
		Reflexion.addActionListener(this);
		Trans.add(Reflexion);

		Autor = new JMenuItem("Autor");
		Autor.setMnemonic('S');
		Autor.setToolTipText("Autor del programa");
		rutad = getClass().getResource("rec/autor.png");
		Autor.setIcon(new ImageIcon(rutad));
		Autor.addActionListener(this);
		Acerca.add(Autor);
		
		Version = new JMenuItem("Version");
		Version.setMnemonic('V');
		rutad = getClass().getResource("rec/version.png");
		Version.setIcon(new ImageIcon(rutad));
		Version.addActionListener(this);
		Acerca.add(Version);
		
		Ayuda = new JMenuItem("Ayuda");
		Ayuda.setMnemonic('H');
		rutad = getClass().getResource("rec/ayuda.png");
		Ayuda.setIcon(new ImageIcon(rutad));
		KeyStroke ak =KeyStroke.getKeyStroke("F1");
		Ayuda.setAccelerator(ak);
		Ayuda.addActionListener(this);
		Acerca.add(Ayuda);
		
		

		Salir = new JMenuItem("Salir");
		Salir.setMnemonic('S');
		Salir.setToolTipText("Salir de la aplicacion");
		rutad = getClass().getResource("rec/salir.png");
		Salir.setIcon(new ImageIcon(rutad));
		Salir.addActionListener(this);
		Inicio.add(Salir);

		popup = new JPopupMenu();
		popup.add(Restaurar);

		this.setBackground(Color.LIGHT_GRAY);
		cont.setLayout(new BorderLayout());
		cont.add(this, BorderLayout.CENTER);
		F = new Figura(fig, t1, t2, t3, t4, t5);
		// barra de herramientas
		BarraH = new JToolBar("Transformaciones", JToolBar.VERTICAL);
		cont.add(BarraH, BorderLayout.EAST);

		rutad = getClass().getResource("rec/escalar.png");
		Action A1 = new AbstractAction("Escalar", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {

				F.escalar_punto(1.1, 1.1);
				repaint();
			}
		};
		A1.putValue(Action.SHORT_DESCRIPTION,
				"Esclar la figura un cantidad especifica");
		A1.putValue(Action.MNEMONIC_KEY, new Integer('E'));
		A1.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/escalar.png");
		Action A2 = new AbstractAction("Escalar", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {

				F.escalar_punto(.9, .9);
				repaint();
			}
		};
		A2.putValue(Action.SHORT_DESCRIPTION,
				"Disminuye el tamaño de la figura");
		A2.putValue(Action.MNEMONIC_KEY, new Integer('D'));
		A2.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/restaurar.png");
		Action A3 = new AbstractAction("Restaurar", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				F.restablecer();
				repaint();
			}
		};
		A3.putValue(Action.SHORT_DESCRIPTION,
				"Restaura las coordenadas originales");
		A3.putValue(Action.MNEMONIC_KEY, new Integer('R'));
		A3.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/rotarcontra.png");
		Action A4 = new AbstractAction("Rotar en Contra", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				F.rotar_sp(5);
				repaint();
			}
		};
		A4.putValue(Action.SHORT_DESCRIPTION,
				"Rota la figura en contra de las manecillas");
		A4.putValue(Action.MNEMONIC_KEY, new Integer('C'));
		A4.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/rotarsen.png");
		Action A5 = new AbstractAction("Rotar en Sentido", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				F.rotar_cp(5);
				repaint();
			}
		};
		A5.putValue(Action.SHORT_DESCRIPTION,
				"Rota la figura en el sentido de las manecillas");
		A5.putValue(Action.MNEMONIC_KEY, new Integer('S'));
		A5.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/deformar.png");
		Action A6 = new AbstractAction("Deformar", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				F.deformar_punto(-.1, -.1);
				repaint();
			}
		};
		A6.putValue(Action.SHORT_DESCRIPTION, "Deforma la figura cada click");
		A6.putValue(Action.MNEMONIC_KEY, new Integer('F'));
		A6.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/trasladar.png");
		Action A7 = new AbstractAction("Trasladar", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				Trasladar_Dialogo obj = new Trasladar_Dialogo(vent, true);
				int vec[] = obj.mostrar();
				F.Trasladar(vec[0], vec[1]);
				repaint();
			}
		};
		A7.putValue(Action.SHORT_DESCRIPTION, "Traslada la figura");
		A7.putValue(Action.MNEMONIC_KEY, new Integer('T'));
		A7.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));

		rutad = getClass().getResource("rec/refle.png");
		Action A8 = new AbstractAction("Reflexion", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				Reflex_Dialogo obj = new Reflex_Dialogo(vent, true);
				int vec[] = obj.mostrar();
				F.reflex_punto(vec[0], vec[1]);
				repaint();
			}
		};
		A8.putValue(Action.SHORT_DESCRIPTION, "Reflexion de la figura");
		A8.putValue(Action.MNEMONIC_KEY, new Integer('l'));
		A8.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		/* Accion de ayuda para mostrar el dialogo */

		rutad = getClass().getResource("rec/ayuda.png");
		Action A9 = new AbstractAction("Reflexion", new ImageIcon(rutad)) {

			public void actionPerformed(ActionEvent arg0) {
				String mensaje="Ayuda \n";
						mensajeAyuda(mensaje);
			}
		};
		A9.putValue(Action.SHORT_DESCRIPTION,
				"Obtener ayuda sobre el uso del programita!!");
		A9.putValue(Action.MNEMONIC_KEY, new Integer('1'));
		A9.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		BarraH.add(A3);
		BarraH.add(A1);
		BarraH.add(A2);
		BarraH.add(A4);
		BarraH.add(A5);
		BarraH.add(A6);
		BarraH.add(A7);
		BarraH.add(A8);
		BarraH.add(A9);

		this.addMouseListener(new RatonListener(this));
		this.addMouseMotionListener(new Arrastre(this));
		this.addMouseWheelListener(this);
		addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent Me) {
				if (Me.isPopupTrigger()) {
					popup.show(Me.getComponent(), Me.getX(), Me.getY());
				}
			}
		});
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setVisible(true);
		vent.setLocationRelativeTo(null);
	}

	public void processMouseEvent(MouseEvent event) {
		if (event.isPopupTrigger()) {
			popup.show(event.getComponent(), event.getX(), event.getY());
		}
		super.processMouseEvent(event);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		F.dibujar(g);
		F.zoom();
		F.dibujarz(g);
	}
	public void mensajeAyuda(String mensaje)
	{
		JOptionPane.showMessageDialog(this, mensaje,"Ayuda",JOptionPane.INFORMATION_MESSAGE);		
	}
	public void mensajeAutor(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje,"Autor",JOptionPane.INFORMATION_MESSAGE);
	}
	public void mensajeVersion(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje,"Version",JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		double cuerpo[][] = new double[][] { { 200, 140 }, { 320, 140 },
				{ 320, 300 }, { 310, 300 }, { 310, 310 }, { 250, 310 },
				{ 250, 370 }, { 240, 370 }, { 240, 380 }, { 230, 380 },
				{ 230, 370 }, { 220, 370 }, { 220, 310 }, { 180, 310 },
				{ 180, 310 }, { 180, 370 }, { 170, 370 }, { 170, 380 },
				{ 160, 380 }, { 160, 370 }, { 150, 370 }, { 150, 310 },
				{ 90, 310 }, { 90, 300 }, { 80, 300 }, { 80, 140 },
				{ 200, 140 }, };
		double cabeza[][] = new double[][] {
				{ 200, 40 },
				{ 260, 40 },
				{ 260, 20 },
				{ 270, 20 },
				{ 270, 10 },// 5
				{ 280, 10 },
				{ 280, 0 },
				{ 290, 0 },
				{ 290, 20 },
				{ 280, 20 },// 10
				{ 280, 40 },
				{ 270, 40 },
				{ 270, 50 },
				{ 280, 50 },
				{ 280, 60 },// 15
				{ 290, 60 },
				{ 290, 70 },
				{ 300, 70 },
				{ 300, 90 },
				{ 310, 90 },// 20
				{ 310, 110 }, { 320, 110 },
				{ 320, 130 },
				{ 80, 130 },
				{ 80, 110 },// 25
				{ 90, 110 }, { 90, 90 }, { 100, 90 },
				{ 100, 70 },
				{ 110, 70 },// 30
				{ 110, 60 }, { 120, 60 }, { 120, 50 },
				{ 130, 50 },
				{ 130, 40 },// 35
				{ 120, 40 }, { 120, 20 }, { 110, 20 }, { 110, 0 },
				{ 120, 0 },// 40
				{ 120, 10 }, { 130, 10 }, { 130, 20 }, { 140, 20 },
				{ 140, 40 }, { 200, 40 } };// 44
		double brazo_izq[][] = new double[][] { { 40, 150 }, { 50, 150 },
				{ 50, 140 }, { 60, 140 }, { 60, 150 }, { 70, 150 },
				{ 70, 240 }, { 60, 240 }, { 60, 250 }, { 50, 250 },
				{ 50, 240 }, { 40, 240 }, { 40, 150 } };

		double brazo_der[][] = new double[][] { { 330, 150 }, { 340, 150 },
				{ 340, 140 }, { 350, 140 }, { 350, 150 }, { 360, 150 },
				{ 360, 240 }, { 350, 240 }, { 350, 250 }, { 340, 250 },
				{ 340, 240 }, { 330, 240 }, { 330, 150 } };
		double ojo_izq[][] = new double[][]{{130,80},{150,80},{150,100},{130,100},{130,80}};
		double ojo_der[][] = new double[][]{{250,80},{270,80},{270,100},{250,100},{250,80}};
		
		//Logo Github
		//contorno
		double git1[][]=new double[][]{
			/* */{250,112},/* */{265,113},/* */{276,114},/* */{284,115},
			/* */{287,116},/* */{293,115},/* */{294,114},/* */{296,113},
			/* */{297,112},/* */{298,112},/* */{300,111},/* */{301,110},
						
			/* */{303,109},/* */{305,108},/* */{307,107},/* */{309,106},
			/* */{311,105},/* */{313,104},/* */{315,103},/* */{317,102},
			/* */{319,101},/* */{321,100},/* */{325,99},/* */{329,98},
							
			/* */{340,98},/* */{341,99},/* */{342,101},/* */{343,103},
			/* */{344,105},/* */{345,109},/* */{346,116},/* */{345,134},
			/* */{344,141},/* */{345,146},/* */{346,147},/* */{347,148},
			{348,149},{349,150},{352,154},{355,159},{358,164},{360,169},
			{361,171},{364,180},{365,219},{364,226},{362,235},{361,239},{359,246},
			{358,252},{355,260},{351,265},{347,269},{343,274},{336,278},{331,280},
			{326,284},{312,286},{306,285},{301,287},{294,289},{288,289},
			
			{209,289},{208,288},{202,287},{198,286},{193,285},{187,281},
			{178,278},{171,274},{162,265},{154,260},{148,254},{144,250},{142,243},
			{138,240},{137,235},{134,230},{133,224},{132,219},{130,190},{131,182},
			{132,172},{134,164},{138,160},{140,155},{143,150},{147,149},{149,146},
			{148,140},{147,135},{146,119},{147,113},{148,108},{149,105},{150,102},
			{151,101},{152,98},
			{161,98},{162,99},{166,100},{170,101},{171,102},{175,103},{178,104},
			{180,105},{182,106},{184,107},{186,108},{188,109},{190,110},{192,111},
			{194,112},{196,113},{198,114},{200,115},{201,116},{204,118},{208,116},
			{211,115},{217,114},{223,113},{233,111},{250,112}
			//124

};
		//ojo derecho
		double git2[][]=new double[][]{
				{300,213},{308,216},{310,223},
				{310,233},{308,239},{300,243},
				{294,243},{290,233},{290,223},
				{294,216},{300,213},
		};
		//ojo izq
		double git3[][]=new double[][]{
				{200,213},{208,216},{210,223},
				{210,233},{208,239},{200,243},
				{194,243},{190,233},{190,223},
				{194,216},{200,213},
						};
		double git4[][]=new double[][]{
				{360,237},{390,238},{420,239},
				{437,241},
				
		};
		double git5[][]=new double[][]{
				{138,237},{114,238},{95,239},
				{63,241},
				
		};
		
		int e = 0;

		Principal obf = null;
		double v5[][] = { { 1, 1 } };
		try {
			e = Integer
					.parseInt(JOptionPane
							.showInputDialog("0) Figura de 50 puntos. 1) Figura de 150."));
		} catch (NumberFormatException w) {
			e = 0;
		}
		

		if (e == 0) {
			obf = new Principal("Figura de 50 puntos", cuerpo, cabeza,
					brazo_der, brazo_izq, ojo_izq, ojo_der);

			obf.max = 590;
			obf.may = 548;
			obf.mix = 139;
			obf.miy = 189;
		}
		if (e == 1) {
			obf = new Principal("Figura de 150 puntos", git1, git2,
					git3, git4, git5, v5);

			obf.max = 691;
			obf.may = 486;
			obf.mix = 136;
			obf.miy = 86;
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == Restaurar) {
			F.restablecer();
		} else if (arg0.getSource() == Salir) {
			System.exit(0);
		} else if (arg0.getSource() == Escalar) {
			String cantx = JOptionPane
					.showInputDialog("Cantidad a escalar en x");
			String canty = JOptionPane
					.showInputDialog("Cantidad a escalar en y");
			double cx = 0.0, cy = 0.0;
			try {
				cx = Double.parseDouble(cantx);
				cy = Double.parseDouble(canty);
			} catch (NumberFormatException e) {
				cx = 1.0;
				cy = 1.0;
			}
			F.escalar_H(cx, cy);
		} else if (arg0.getSource() == Deformar) {
			String cantx = JOptionPane
					.showInputDialog("Cantidad a deformar en x");
			String canty = JOptionPane
					.showInputDialog("Cantidad a deformar en y");
			double cx = 0.0, cy = 0.0;
			try {
				cx = Double.parseDouble(cantx);
				cy = Double.parseDouble(canty);
			} catch (NumberFormatException e) {
				cx = 0.0;
				cy = 0.0;
			}
			F.deformar_h(cx, cy);
		} else if (arg0.getSource() == Rotarc) {
			String cantx = JOptionPane.showInputDialog("Cantidad a rotar");
			int ang = 0;
			try {
				ang = Integer.parseInt(cantx);
			} catch (NumberFormatException e) {
				ang = 1;
			}
			F.rotacion_sh(ang);
		}
		if (arg0.getSource() == Rotars) {
			String cantx = JOptionPane.showInputDialog("Cantidad a rotar");
			int ang = 0;
			try {
				ang = Integer.parseInt(cantx);
			} catch (NumberFormatException e) {
				ang = 1;
			}
			F.rotacion_ch(ang);
		} else if (arg0.getSource() == Trasladar) {
			String cantx = JOptionPane
					.showInputDialog("Cantidad a trasladar en x");
			String canty = JOptionPane
					.showInputDialog("Cantidad a trasladar en y");
			int Tx = 0, Ty = 0;
			try {
				Tx = Integer.parseInt(cantx);
				Ty = Integer.parseInt(canty);
			} catch (NumberFormatException e) {
				Tx = 0;
				Ty = 0;
			}
			F.Trasladar(Tx, Ty);
		} else if (arg0.getSource() == Reflexion) {
			String cantx = JOptionPane
					.showInputDialog("-1 para Reflexion en x y 1 si no");
			String canty = JOptionPane
					.showInputDialog("-1 para Reflexion en y y 1 si no");
			int rx = 0, ry = 0;
			try {
				rx = Integer.parseInt(cantx);
				ry = Integer.parseInt(canty);
			} catch (NumberFormatException e) {
				rx = 1;
				ry = 1;
			}
			F.reflex_H(rx, ry);
		}else if(arg0.getSource()== Ayuda){
			String mensaje="Ayuda \n";
					mensajeAyuda(mensaje);
			
		}
		else if(arg0.getSource()== Autor){
			String mensaje="Acerca del autor \n"+
					"\n Dante Omar Arciga Camarena"+
					"\n 09420273"+
					"\n Github https://github.com/darciga";
					mensajeAutor(mensaje);
			
		}
		else if(arg0.getSource()== Version){
			String mensaje="Versionado en Github \n"+
					"\n Repositorio github"+
					"\n https://github.com/darciga/";
					mensajeVersion(mensaje);
			
		}
		repaint();
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
		int movimiento = arg0.getWheelRotation();
		if (movimiento < 0) {
			F.escalar_punto(1.1, 1.1);
		} else {
			F.escalar_punto(.9, .9);
		}
		repaint();
	}
}

class Trasladar_Dialogo extends JDialog {

	JLabel et1, et2;
	JTextField ct1, ct2;
	JButton Ac, Ca;
	int coords[];

	public Trasladar_Dialogo(JFrame V, boolean modo) {
		super(V, modo);
		et1 = new JLabel("X:");
		et2 = new JLabel("Y:");
		ct1 = new JTextField(5);
		ct2 = new JTextField(5);
		Ac = new JButton("Aceptar");
		Ca = new JButton("Cancelar");
		setLayout(new FlowLayout());
		add(et1);
		add(ct1);
		add(et2);
		add(ct2);
		add(Ac);
		add(Ca);
		this.setTitle("Traslada un figura a la coordenada especificada");
		this.setSize(400, 80);
		this.setLocation(85, 480);
		coords = new int[2];
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				coords[0] = 0;
				coords[1] = 0;
				setVisible(false);
				dispose();
			}
		});
		Ac.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String xc = ct1.getText();
				String yc = ct2.getText();
				try {
					coords[0] = Integer.parseInt(xc);
					coords[1] = Integer.parseInt(yc);
				} catch (NumberFormatException e) {
					coords[0] = 0;
					coords[1] = 0;
				}
				setVisible(false);
				dispose();
			}
		});
		Ca.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				coords[0] = 0;
				coords[1] = 0;
				setVisible(false);
				dispose();
			}
		});
	}

	public int[] mostrar() {
		setVisible(true);
		dispose();
		return coords;
	}
}

class Reflex_Dialogo extends JDialog {

	JRadioButton rx, ry, rxy;
	ButtonGroup grupo;
	JButton Ac, Ca;
	int coords[];

	public Reflex_Dialogo(JFrame V, boolean modo) {
		super(V, modo);
		setLayout(new FlowLayout());
		setSize(400, 85);
		setLocation(90, 450);
		setTitle("Reflexion de la figura de acuerdo a un eje");
		rx = new JRadioButton("X", false);
		ry = new JRadioButton("Y", false);
		rxy = new JRadioButton("XY", false);
		grupo = new ButtonGroup();
		grupo.add(rx);
		grupo.add(ry);
		grupo.add(rxy);
		Ac = new JButton("Aceptar");
		Ca = new JButton("Cancelar");
		add(rx);
		add(ry);
		add(rxy);
		add(Ac);
		add(Ca);
		coords = new int[2];
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				coords[0] = 1;
				coords[1] = 1;
				setVisible(false);
				dispose();
			}
		});
		Ac.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (rx.isSelected()) {
					coords[0] = -1;
					coords[1] = 1;
				} else if (ry.isSelected()) {
					coords[0] = 1;
					coords[1] = -1;
				} else if (rxy.isSelected()) {
					coords[0] = -1;
					coords[1] = -1;
				} else {
					coords[0] = 1;
					coords[1] = 1;
				}
				setVisible(false);
				dispose();
			}
		});
		Ca.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				coords[0] = 1;
				coords[1] = 1;
				setVisible(false);
				dispose();
			}
		});
	}

	public int[] mostrar() {
		setVisible(true);
		dispose();
		return coords;
	}
}
