package br.edu.iff.gestaopatrimonio.models;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    public int id;

    public String nome;

    public String biografia;

    public List<NomeAlternativo> nomeAlternativo = new ArrayList<NomeAlternativo> ();

}
