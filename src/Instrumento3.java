import sintese.*;

public class Instrumento3 extends Dispositivo{
	Envoltoria e_amplitudeOscilador, e_frequenciaAux;
	Curva c_amplitudeOscilador, c_frequenciaAux;
	Oscilador oscilador, oscAux;
	Ruido ruido;
	Somador soma1, soma2;
	float aux;
	//String nome = "Instrumento 3";
	
	
	public Instrumento3(){
		super();
		atualiza();
	}
	
	
	private void atualiza(){
		c_amplitudeOscilador = new Curva(360);
		c_amplitudeOscilador.addPonto(0, 0);
		c_amplitudeOscilador.addPonto(20, 10000);
		c_amplitudeOscilador.addPonto(280, 7000);
		c_amplitudeOscilador.addPonto(360, 0);
		
		e_amplitudeOscilador = new Envoltoria();
		e_amplitudeOscilador.setCURVA(c_amplitudeOscilador);
		
		c_frequenciaAux = new Curva(360);
		c_frequenciaAux.addPonto(0, super.frequencia);
		c_frequenciaAux.addPonto(360, super.frequencia);
		
		e_frequenciaAux = new Envoltoria();
		e_frequenciaAux.setCURVA(c_frequenciaAux);
		
		aux = frequencia/1000;//escalonamento
		aux = 0.0075f*aux;
		oscAux = new Oscilador(aux,5,0);
		ruido = new Ruido(aux,10,0);
		
		soma1 = new Somador(oscAux,ruido);
		soma2 = new Somador(e_frequenciaAux,soma1);
		
		oscilador = new Oscilador(e_amplitudeOscilador,soma2);
	}
	
	public float getSaida()
    { return oscilador.getSaida();
    }
	public void relogio()
    { oscAux.relogio();
      oscilador.relogio();
    }
	public void setFrequencia(float f)
    { super.frequencia = f;
      atualiza();
    }
	public void setGanho(float ganho_)
    { ganho = ganho_;
    }
}
