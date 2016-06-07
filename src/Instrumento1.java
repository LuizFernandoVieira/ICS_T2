import sintese.*;

public class Instrumento1 extends Dispositivo{
	Oscilador oscilador;
	Ruido ruido;
	//String nome = "Instrumento 1";
	
	public Instrumento1(){
		super();
		atualiza();
	}
	
	private void atualiza(){
		Curva c_amplitudeRuido = new Curva(360);
		Float tonal = 0.00001f;
		
		c_amplitudeRuido.addPonto(0, 0);
		c_amplitudeRuido.addPonto(20, 10000);
		c_amplitudeRuido.addPonto(280, 7000);
		c_amplitudeRuido.addPonto(360, 0);
		
		Envoltoria e_amplitudeRuido = new Envoltoria();
		e_amplitudeRuido.setCURVA(c_amplitudeRuido);
		
		Curva c_frequenciaRuido = new Curva(360);
		c_frequenciaRuido.addPonto(0, tonal*frequencia);
		c_frequenciaRuido.addPonto(360, tonal*frequencia);
		
		Envoltoria e_frequenciaRuido = new Envoltoria();
		e_frequenciaRuido.setCURVA(c_frequenciaRuido);
		
		Curva c_frequenciaoscilador = new Curva(360);
		c_frequenciaoscilador.addPonto(0, frequencia);
		c_frequenciaoscilador.addPonto(360, frequencia);
		
		Envoltoria e_frequenciaoscilador = new Envoltoria();
		e_frequenciaoscilador.setCURVA(c_frequenciaoscilador);
		
		Ruido ruido = new Ruido(e_amplitudeRuido,e_frequenciaRuido);
		
		oscilador = new Oscilador(ruido, e_frequenciaoscilador);
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
