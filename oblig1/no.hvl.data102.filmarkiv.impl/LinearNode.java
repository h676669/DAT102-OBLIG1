package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {

    public T data;
    public LinearNode<T> neste;

    public LinearNode() {
        data = null;
        neste = null;
    }
    public LinearNode(T data) {
        this.data = data;
        neste = null;
    }

    public LinearNode(T data, LinearNode<T> neste) {
        this.data = data;
        this.neste = neste;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinearNode<T> getNeste() {
        return neste;
    }

    public void setNeste(LinearNode<T> neste) {
        this.neste = neste;
    }
}
