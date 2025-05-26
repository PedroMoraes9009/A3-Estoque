/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Categoria {
    private int id;
    private String nome;
    private String tamanho;
    private String embalagem;

    public Categoria(String nome, String tamanho, String embalagem) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public String getTamanho() { return tamanho; }
    public String getEmbalagem() { return embalagem; }

    @Override
    public String toString() {
        return nome + " [" + tamanho + " - " + embalagem + "]";
    }
}


