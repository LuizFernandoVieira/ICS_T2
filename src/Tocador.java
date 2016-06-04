import sintese.*;

public class Tocador {
	Instrumento1 i1;
	Instrumento2 i2;
	Instrumento3 i3;
	Dispositivo iSelecionado;
	Melodias melodias;
	Melodia mSelecionada;
	Som som;
	
	public Tocador(){
		i1 = new Instrumento1();
		i2 = new Instrumento2();
		i3 = new Instrumento3();
		iSelecionado = i3;//default
		melodias = new Melodias();
		mSelecionada = melodias.melodia7;
		som = mSelecionada.getSom(iSelecionado);
		som.visualiza();
	}
	
	public void tocarMelodia(){
		som = mSelecionada.getSom(iSelecionado);
		som.salvawave();
		som.tocawave();
		som.visualiza();
	}
	public void tocarNota(float frequencia){
		iSelecionado.setFrequencia(frequencia);
		som = new Som(iSelecionado,2);
		som.salvawave();
		som.tocawave();
	}
	public void alterarInstrumento(Dispositivo novo){
		iSelecionado = novo;
	}
	public void alterarMelodia(Melodia nova){
		mSelecionada = nova;
	}
}
