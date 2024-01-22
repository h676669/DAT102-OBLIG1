package no.hvl.data102.filmarkiv.impl;

class LinearNode<T> {

    private T data;
    private LinearNode<T> neste;

    public LinearNode(T data) {
        this.data = data;
        neste = null;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    LinearNode<T> getNeste() {
        return neste;
    }

    void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}
