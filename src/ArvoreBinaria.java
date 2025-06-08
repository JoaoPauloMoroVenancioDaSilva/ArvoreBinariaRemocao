public class ArvoreBinaria {
    private No raiz;
    private int modoRemocaoDoisFilhos; //1 = Maior dos menores; // 2 = Menor dos maiores

    public ArvoreBinaria(int conteudo) {
        raiz = new No(conteudo);
        modoRemocaoDoisFilhos = 0;
    }

    public int getModoRemocaoDoisFilhos() {
        return modoRemocaoDoisFilhos;
    }

    public void setModoRemocaoDoisFilhos(int modoRemocaoDoisFilhos) {
        this.modoRemocaoDoisFilhos = modoRemocaoDoisFilhos;
    }

    public boolean estaVazia() {
        if(raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void visualizarPreOrdem(){
        preOrdem(this.raiz);
    }

    public void visualizarEmOrdem() {
        emOrdem(this.raiz);
    }

    public void visualizarPosOrdem() {
        posOrdem(this.raiz);
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void inserirRecursivoRedirecionamento2(int conteudo) {
        No novoNo = new No(conteudo);
        inserirRecursivo2(this.raiz, novoNo);
    }

    private void inserirRecursivo2(No aux, No novoNo) {
        if(estaVazia()) {
            this.raiz = novoNo;
            return;
        }
        if (novoNo.getConteudo() < aux.getConteudo()) {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(novoNo);
                novoNo.setPai(aux);
            } else {
                inserirRecursivo2(aux.getEsquerda(), novoNo);
            }
        } else {
            if (aux.getDireita() == null) {
                aux.setDireita(novoNo);
                novoNo.setPai(aux);
            } else {
                inserirRecursivo2(aux.getDireita(), novoNo);
            }
        }
    }

    public void removerNo(int remova){
        No futuroRemovido = buscarNo(remova, this.raiz);
        if(futuroRemovido == null) {
            return;
        }
        String descricaoDoNo = tipoRemocao(futuroRemovido);
        remocaoQueTemQSerUsada(futuroRemovido, descricaoDoNo);
    }


    public No buscarNo(int conteudo, No aux) {
        if (conteudo == aux.getConteudo()) {
            System.out.println("Nó com esse valor encontrado.");
            return aux;
        }
        else if (aux.getConteudo() == null) {
            System.out.println("O nó com esse valor não existe na sua árvore.");
            return null;
        }
        else if (conteudo < aux.getConteudo()) {
            aux = aux.getEsquerda();
            if (aux.getConteudo() == null){
                return null;
            }
            return buscarNo(conteudo, aux);
        }
        else {
            aux = aux.getDireita();
            if (aux.getConteudo() == null){
                return null;
            }
            return buscarNo(conteudo, aux);
        }
    }

    public String tipoRemocao(No buscado) {
        if (buscado.getEsquerda() == null && buscado.getDireita() == null) {
            System.out.println("O nó que você quer remover é uma Folha");
            return "Folha";
        }
        else if (buscado.getEsquerda() != null && buscado.getDireita() == null) {
            System.out.println("O nó que você quer remover possui um Filho à esquerda");
            return "Filho a esquerda";
        }
        else if (buscado.getEsquerda() == null && buscado.getDireita() != null) {
            System.out.println("O nó que você quer remover possui um Filho à direita");
            return "Filho a direita";
        }
        else {
            System.out.println("O nó que você quer remover possui Dois Filhos");
            return "Dois Filhos";
        }
    }

    public void remocaoQueTemQSerUsada(No removido, String descricao) {
        if (descricao == "Folha") {
            removerNoFolha(removido);
        }
        else if (descricao == "Filho a esquerda") {
            removerNoFilhoAEsquerda(removido);
        }
        else if (descricao == "Filho a direita") {
            removerNoFilhoADireita(removido);
        }
        else if (descricao == "Dois Filhos") {
            removerNoDoisFilhos(removido);
        }
    }

    public void removerNoFolha(No removido) {
        No pai = removido.getPai();

        if (pai == null) {
            raiz = null;
        } else if (pai.getEsquerda() == removido) {
            pai.setEsquerda(null);
        } else {
            pai.setDireita(null);
        }
    }

    public void removerNoFilhoAEsquerda(No removido){
        No filho = removido.getEsquerda();
        filho.setPai(removido.getPai());

        if (removido.getPai() == null) {
            this.raiz = filho;
        } else if (removido.getPai().getEsquerda() == removido) {
            removido.getPai().setEsquerda(filho);
        } else {
            removido.getPai().setDireita(filho);
        }
    }

    public void removerNoFilhoADireita(No removido){
        No filho = removido.getDireita();
        filho.setPai(removido.getPai());

        if (removido.getPai() == null) {
            this.raiz = filho;
        } else if (removido.getPai().getEsquerda() == removido) {
            removido.getPai().setEsquerda(filho);
        } else {
            removido.getPai().setDireita(filho);
        }
    }

    public void removerNoDoisFilhos(No removido) {
        No substituto;

        if (this.modoRemocaoDoisFilhos == 1) { // Maior dos menores
            substituto = removido.getEsquerda();
            while (substituto.getDireita() != null) {
                substituto = substituto.getDireita();
            }
        } else { // Menor dos maiores
            substituto = removido.getDireita();
            while (substituto.getEsquerda() != null) {
                substituto = substituto.getEsquerda();
            }
        }

        removido.setConteudo(substituto.getConteudo());

        No paiSubstituto = substituto.getPai();
        No filhoSubstituto = null;
        if (substituto.getEsquerda() != null) {
            filhoSubstituto = substituto.getEsquerda();
        } else if (substituto.getDireita() != null) {
            filhoSubstituto = substituto.getDireita();
        }

        if (paiSubstituto != null) {
            if (paiSubstituto.getEsquerda() == substituto) {
                paiSubstituto.setEsquerda(filhoSubstituto);
            } else {
                paiSubstituto.setDireita(filhoSubstituto);
            }
        }

        if (filhoSubstituto != null) {
            filhoSubstituto.setPai(paiSubstituto);
        }
    }
}