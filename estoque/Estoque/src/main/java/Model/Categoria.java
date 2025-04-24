/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Categoria {
    private String nome;
    private String tamanho;
    private String embalagem;

    public Categoria(String nome, String tamanho, String embalagem) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " [" + tamanho + " - " + embalagem + "]";
    }
}

