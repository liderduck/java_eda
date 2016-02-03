package org.eda.examenJulio2013Ejercicio3;

public class Casilla {

	private String color;
	private int valor;
	
	
	public Casilla(String pColor, int pValor)
	{
		this.color=pColor;
		this.valor=pValor;
	}
	
	
	public String getColor()
	{
		return this.color;
	}
	
	public int getValor()
	{
		return this.valor;
	}
	
	public String toString()
	{
		return this.getValor()+","+ this.getColor() ;
	}
	
	
	public boolean equals(Casilla casilla)
	{
		if(this.getColor()==casilla.getColor())
		{
			if(this.getValor()==casilla.getValor())
			{
				return true;
			}

		}
		
		return false;


	}
	
}
