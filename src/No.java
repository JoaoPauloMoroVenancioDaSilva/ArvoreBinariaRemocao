public class No {
    private Integer conteudo;
    private No Esquerda;
    private No Direita;
    private No pai;

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.Esquerda = null;
        this.Direita = null;
        this.pai = null;
    }


    public Integer getConteudo() {
        return conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    public No getEsquerda() {
        return Esquerda;
    }

    public void setEsquerda(No esquerda) {
        Esquerda = esquerda;
    }

    public No getDireita() {
        return Direita;
    }

    public void setDireita(No direita) {
        Direita = direita;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }
}
