package org.example;

import java.util.List;

public class Mobilier
{
    private String nume;
    private List<Placa> placi;

    public Mobilier() {}

    public Mobilier(String nume, List<Placa> placi)
    {
        this.nume = nume;
        this.placi = placi;
    }

    //getter & stter
    public String getNume()
    {
        return nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public List<Placa> getPlaci()
    {
        return placi;
    }

    public void setPlaci(List<Placa> placi)
    {
        this.placi = placi;
    }

    @Override
    public String toString()
    {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
