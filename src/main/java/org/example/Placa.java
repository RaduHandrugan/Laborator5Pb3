package org.example;

import java.util.Arrays;

public class Placa
{
    private String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi; // 4 elemente boolean
    private int nrBucati;

    public Placa() {}

    public Placa(String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nrBucati)
    {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nrBucati = nrBucati;
    }

    // get & set
    public String getDescriere()
    {
        return descriere;
    }

    public void setDescriere(String descriere)
    {
        this.descriere = descriere;
    }

    public int getLungime()
    {
        return lungime;
    }

    public void setLungime(int lungime)
    {
        this.lungime = lungime;
    }

    public int getLatime()
    {
        return latime;
    }

    public void setLatime(int latime)
    {
        this.latime = latime;
    }

    public Orientare getOrientare()
    {
        return orientare;
    }

    public void setOrientare(Orientare orientare)
    {
        this.orientare = orientare;
    }

    public boolean[] getCanturi()
    {
        return canturi;
    }

    public void setCanturi(boolean[] canturi)
    {
        this.canturi = canturi;
    }

    public int getNrBucati()
    {
        return nrBucati;
    }

    public void setNrBucati(int nrBucati)
    {
        this.nrBucati = nrBucati;
    }

    @Override
    public String toString()
    {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nrBucati=" + nrBucati +
                '}';
    }
}
