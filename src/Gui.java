import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Gui extends Frame implements ActionListener, ListSelectionListener{
	private Button play,C1,Cs,D,Ds,E,F,Fs,G,Gs,A,As,B,C2;
	private JList<String> listaM,listaI;
	float frequencia;
	
	Tocador tocador;
	
	public Gui(Tocador tocador){
		
		this.tocador = tocador;
		
		setLayout(new FlowLayout());
		
		String[] listaMelodias = {"Escala Temperada Maior", "bwt 775 invencao 4 esquerda     ", "bwt 775 invencao 4 direita", "drawing quintet flauta","bwt 988 v03"};
		String[] listaInstrumentos = {"Instrumento 1     ","Instrumento 2","Instrumento 3"};
		
		listaI = new JList<String>(listaInstrumentos);
		listaI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaI.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listaI.addListSelectionListener(this);
		add(listaI,0);
		
		listaM = new JList<String>(listaMelodias);
		listaM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaM.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listaM.addListSelectionListener(this);
		add(listaM,1);
		
		play = new Button("Toca Melodia");
		play.addActionListener(this);
		add(play);
		
		C1 = new Button("C");
		C1.addActionListener(this);
		add(C1);
		
		Cs = new Button("C#");
		Cs.addActionListener(this);
		add(Cs);
		
		D = new Button("D");
		D.addActionListener(this);
		add(D);
		
		Ds = new Button("D#");
		Ds.addActionListener(this);
		add(Ds);
		
		E = new Button("E");
		E.addActionListener(this);
		add(E);
		
		F = new Button("F");
		F.addActionListener(this);
		add(F);
		
		Fs = new Button("F#");
		Fs.addActionListener(this);
		add(Fs);
		
		G = new Button("G");
		G.addActionListener(this);
		add(G);
		
		Gs = new Button("G#");
		Gs.addActionListener(this);
		add(Gs);
		
		A = new Button("A");
		A.addActionListener(this);
		add(A);
		
		As = new Button("A#");
		As.addActionListener(this);
		add(As);
		
		B = new Button("B");
		B.addActionListener(this);
		add(B);
		
		C2 = new Button("C");
		C2.addActionListener(this);
		add(C2);
		
		addWindowListener(new WindowAdapter(){
		  	public void windowClosing(WindowEvent e){
		  		System.exit(0);
		  	}
		});
		
		setTitle("Tocador");
		setSize(420,190);
		setVisible(true);
	}
	
	public void valueChanged(ListSelectionEvent e){
		
		
		if (e.getValueIsAdjusting() == false) {
			Object source = e.getSource();
			if (source == listaM){
				int i = listaM.getSelectedIndex();
				if (i == -1)
					play.setEnabled(false);
				if (i == 0)
					tocador.alterarMelodia(tocador.melodias.melodia1);
				if (i == 1)
					tocador.alterarMelodia(tocador.melodias.melodia2);
				if (i == 2)
					tocador.alterarMelodia(tocador.melodias.melodia3);
				if (i == 3)
					tocador.alterarMelodia(tocador.melodias.melodia4);
				if (i == 4)
					tocador.alterarMelodia(tocador.melodias.melodia5);
			}
			else if (source == listaI){
				int i = listaI.getSelectedIndex();
				if (i == -1)
					play.setEnabled(false);
				if (i == 0)
					tocador.alterarInstrumento(tocador.i1);
				if (i == 1)
					tocador.alterarInstrumento(tocador.i2);
				if (i == 2)
					tocador.alterarInstrumento(tocador.i3);
			}
	    }
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();

		if (source == play){
			tocador.tocarMelodia();
			return;
		}
		if (source == C1)
			frequencia = 261.626f;
		if (source == Cs)
			frequencia = 277.183f;
		if (source == D)
			frequencia = 293.665f;
		if (source == Ds)
			frequencia = 311.127f;
		if (source == E)
			frequencia = 329.628f;
		if (source == F)
			frequencia = 349.228f;
		if (source == Fs)
			frequencia = 369.994f;
		if (source == G)
			frequencia = 391.995f;
		if (source == Gs)
			frequencia = 415.305f;
		if (source == A)
			frequencia = 440.000f;
		if (source == As)
			frequencia = 466.164f;
		if (source == B)
			frequencia = 493.883f;
		if (source == C2)
			frequencia = 523.251f;
		tocador.tocarNota(frequencia);
		return;
	}
	
}
