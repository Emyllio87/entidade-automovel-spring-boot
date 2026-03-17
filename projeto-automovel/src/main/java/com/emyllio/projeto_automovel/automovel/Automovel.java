package com.emyllio.projeto_automovel.automovel;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "automovel")
public class Automovel {

    @Id
    @SequenceGenerator(name = "automovel_sequencia",
            sequenceName = "automovel_sequencia",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "automovel_sequencia")
    private Long codigo;

    private String nome;
    private String modelo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFabricacao;

    private int quantidade;
    private double precoVenda;
    private boolean trioEletrico;

    public Automovel() {}

    public Automovel(Long codigo, String nome, String modelo, LocalDate dataFabricacao,
                     int quantidade, double precoVenda, boolean trioEletrico) {
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.trioEletrico = trioEletrico;
    }

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public LocalDate getDataFabricacao() { return dataFabricacao; }
    public void setDataFabricacao(LocalDate dataFabricacao) { this.dataFabricacao = dataFabricacao; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }

    public boolean isTrioEletrico() { return trioEletrico; }
    public void setTrioEletrico(boolean trioEletrico) { this.trioEletrico = trioEletrico; }
}