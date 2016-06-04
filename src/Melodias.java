import sintese.*;

public class Melodias {
	Melodia melodia1,melodia2,melodia3,melodia4,melodia5,melodia6;
	Melodia melodia7;
	
	double DO4 = 261.626, RE4 = 293.665, MI4 = 329.628, FA4 = 349.228, SOL4 = 391.995, LA4 = 440, SI4 = 493.883;
	
	Melodia nossaMelodia;
	
	public Melodias(){
		melodia1 = Escala.diatonicaMaiorTemperada();
		melodia2 = Tema.tema_bwv775_invencao4_esquerda();
		melodia3 = Tema.tema_bwv775_invencao4_direita();
		melodia4 = Tema.tema_aa_drawing_quintet_flauta();
		melodia5 = Tema.tema_bwv988goldberg_v03_eq();
		melodia6 = Tema.tema_duda_no_frevo_eq();
		melodia7 = minhaMelodia();
	}
	
	Melodia minhaMelodia(){
		nossaMelodia = new Melodia();
		
		nossoAdd(0.7f, FA4);
		nossoAdd(0.4f, LA4);
		nossoAdd(0.3f, SOL4);
		
		nossoAdd(0.4f, 0); //Fazer pausa
		
		nossoAdd(0.4f, DO4);
		nossoAdd(0.7f, FA4);
		nossoAdd(0.4f, LA4);
		nossoAdd(0.3f, SOL4);
		
		nossoAdd(0.6f, 0); //Fazer pausa
		
		//Comeca a cantarolar
		nossoAdd(0.7f, 2*DO4);
		nossoAdd(0.7f, LA4);
		nossoAdd(0.7f, FA4);
		nossoAdd(0.7f, DO4);
		
		nossoAdd(0.4f, 0); //Fazer pausa
		
		nossoAdd(0.4f, RE4);
		nossoAdd(0.4f, MI4);
		nossoAdd(0.4f, FA4);
		nossoAdd(0.7f, RE4);
		nossoAdd(0.4f, FA4);
		nossoAdd(0.8f, DO4);
		
		nossoAdd(0.4f, 0); //Fazer pausa
		nossoAdd(0.8f, SOL4);
		nossoAdd(0.8f, 2*DO4);
		nossoAdd(0.8f, LA4);
		nossoAdd(0.8f, FA4);
		
		nossoAdd(0.4f, 0); //Fazer pausa
		nossoAdd(0.4f, RE4);
		nossoAdd(0.4f, MI4);
		nossoAdd(0.4f, FA4);
		nossoAdd(0.8f, SOL4);
		nossoAdd(0.5f, LA4);
		nossoAdd(0.8f, SOL4);
		
		nossoAdd(0.4f, 0); //Fazer pausa
		nossoAdd(0.4f, LA4);
		nossoAdd(0.4f, 466.164);
		nossoAdd(0.4f, LA4);
		nossoAdd(0.4f, SOL4);
		nossoAdd(0.6f, 2*DO4);
		nossoAdd(0.4f, LA4);
		nossoAdd(0.4f, SOL4);
		nossoAdd(0.4f, FA4);
		
		return nossaMelodia;
	}
	
	public void nossoAdd(float duracao, double freq){
		Nota nota = new Nota(duracao, freq, 200);
		nossaMelodia.addNota(nota);
	}
}
