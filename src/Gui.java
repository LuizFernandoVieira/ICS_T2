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
		
		this.setLocation(new Point (200,500));
		this.setBackground(new Color(171, 245, 255));
		
		setLayout(new FlowLayout());
		
		String[] listaMelodias = {"Daisy Bell", "bwt 775 invencao 4 esquerda     123", "bwt 775 invencao 4 direita", "drawing quintet flauta","bwt 988 v03"};
		String[] listaInstrumentos = {"Instrumento 1","Instrumento 2","Instrumento 3"};
		
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
		
		return;
	}
	
}
