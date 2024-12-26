/*
3. Informații privind necesarul de pal al mai multor piese de mobilier sunt păstrate într-un
fișierul mobilier.json. Palul este un material lemnos sub formă de placă obținut prin presarea de
lemn în combinație cu diferiți lianți. Pentru fiecare piesă de mobilier se memorează numele
piesei (birou, dulap, etajeră, etc) și informații privind plăcile de pal care o compun. Fiecare
placă de pal are o formă dreptunghiulară. Pentru fiecare placă de pal se memorează o descriere
a plăcii, lungimea şi lățimea exprimate in milimetri, orientarea fibrei, canturile pe care le are şi
numărul de bucăți din placa respectivă care intră în compoziția mobilierului. Sa se realizeze un
program care:
a) Citește datele despre piesele de mobilier din fișierul mobilier.json într-o listă de piese
de mobilier (List<Mobilier>) și le afișează
b) Afişează elementele de mobilier din colecție şi plăcile care le compun
c) Afişează caracteristicile plăcilor care compun o anumită piesă de mobilier
d) Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp
de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm (pentru simplitate
se va ţine cont doar de arie, nu şi de posibilitatea de a realiza tăieturile)
Se vor implementa clasele:
- Clasa Mobilier, cu variabilele membre
o nume (String)
o lista plăcilor care o compun List<Placa> placi;
- Clasa Placa
o descriere (String cu valori precum usa, capac, laterală, raft mobil, raft fix, etc)
o lungime în milimetri (întreg)
o laţime în milimetri (întreg)
o orientare– enumerare cu valorile posibile LUNGIME, LATIME, ORICARE
o canturi (vector de 4 elemente boolean). Fiecare piesă de pal care face parte dintr-un
corp de mobilă, are 4 muchii. O anumită valoare booleană indică prezența sau
absența cantului pe muchia corespunzătoare.
o nr_bucati (int)
 */
package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main
{

    //citire fisier
    public static List<Mobilier> citire(String filepath)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filepath);
            return mapper.readValue(file, new TypeReference<List<Mobilier>>() {});
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    //scriere fisier
    public static void scriere(String filepath, List<Mobilier> listaMobilier)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filepath);
            mapper.writeValue(file, listaMobilier);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //calculul coli necesare
    public static int calculeazaColi(List<Placa> placi)
    {
        final int arieCola = 2800 * 2070;
        int arieTotala = 0;

        for (Placa placa : placi)
        {
            int ariePlaca = placa.getLungime() * placa.getLatime() * placa.getNrBucati();
            arieTotala += ariePlaca;
        }

        return (int) Math.ceil((double) arieTotala / arieCola);
    }

    public static void main(String[] args)
    {
        //citires fisier
        String filepath = "src/main/resources/mobilier.json";
        List<Mobilier> listaMobilier = citire(filepath);

        if (listaMobilier != null)
        {

            for (Mobilier mobilier : listaMobilier)
            {
                System.out.println(mobilier);
            }


            String numeMobilier = "Birou";
            for (Mobilier mobilier : listaMobilier)
            {
                if (mobilier.getNume().equalsIgnoreCase(numeMobilier))
                {
                    System.out.println("Placi " + mobilier.getNume() + ":");
                    for (Placa placa : mobilier.getPlaci())
                    {
                        System.out.println(placa);
                    }
                }
            }

            int numarColi = calculeazaColi(listaMobilier.get(0).getPlaci());
            System.out.println("Nr de coli de pal necesare: " + numarColi);
        }
    }
}
