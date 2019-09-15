/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.model;

public class Permissao {

    private int id = 0;
    private String permissao = "";

    public Permissao(int id, String permissao) {
        this.id = id;
        this.permissao = permissao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }

    public String toString() {
        return getPermissao();
    }
}
