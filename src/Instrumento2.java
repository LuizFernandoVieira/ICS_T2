import sintese.*;

public class Instrumento2 extends Dispositivo{
	Envoltoria e_amplitudeOscilador, e_frequenciaAux;
	Oscilador oscilador;
	Ruido ruido;
	Curva c_amplitudeOscilador, c_frequenciaAux;
	Somador soma;
	float aux;
	//String nome = "Instrumento 2";
	
	public Instrumento2(){
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
		c_frequenciaAux.addPonto(0, frequencia);
		c_frequenciaAux.addPonto(360, frequencia);
		
		e_frequenciaAux = new Envoltoria();
		e_frequenciaAux.setCURVA(c_frequenciaAux);
		
		aux = frequencia/1000;//escalonamento
		aux = 0.1f*aux;
		ruido = new Ruido(aux,5*aux,0);
		
		soma = new Somador(e_frequenciaAux,ruido);
		
		oscilador = new Oscilador(e_amplitudeOscilador, soma);
	}
	
	public float getSaida()
    { return oscilador.getSaida();
    }
	public void relogio()
    { oscilador.relogio();
    }
	public void setFrequencia(float f)
    { super.frequencia = f;
      atualiza();
    }
	public void setGanho(float ganho_)
    { ganho = ganho_;
    }
	
}
