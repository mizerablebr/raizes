package br.unifil.raizes;

import java.util.List;

public class Equacao {
    private float x5;
    private float x4;
    private float x3;
    private float x2;
    private float x1;
    private float x0;
    private int epsilon;
    private List<Raiz> raizes;

    public Equacao() {
    }

    public Equacao(float x5, float x4, float x3, float x2, float x1, float x0, int epsilon) {
        this.x5 = x5;
        this.x4 = x4;
        this.x3 = x3;
        this.x2 = x2;
        this.x1 = x1;
        this.x0 = x0;
        this.epsilon = epsilon;
    }

    public float getX0() {
        return x0;
    }

    public void setX0(float x0) {
        this.x0 = x0;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getX3() {
        return x3;
    }

    public void setX3(float x3) {
        this.x3 = x3;
    }

    public float getX4() {
        return x4;
    }

    public void setX4(float x4) {
        this.x4 = x4;
    }

    public float getX5() {
        return x5;
    }

    public void setX5(float x5) {
        this.x5 = x5;
    }

    public int getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(int epsilon) {
        this.epsilon = epsilon;
    }

    public List<Raiz> getRaizes() {
        return raizes;
    }

    public void setRaizes(List<Raiz> raizes) {
        this.raizes = raizes;
    }

    @Override
    public String toString() {
        return "Equacao{" +
                "x0=" + x0 +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", x4=" + x4 +
                ", x5=" + x5 +
                ", epsilon=" + epsilon +
                '}';
    }

    public class Raiz {
        private float intervaloA;
        private float intervaloB;
        private float valor;

        public Raiz() {
        }

        public float getIntervaloA() {
            return intervaloA;
        }

        public void setIntervaloA(float intervaloA) {
            this.intervaloA = intervaloA;
        }

        public float getIntervaloB() {
            return intervaloB;
        }

        public void setIntervaloB(float intervaloB) {
            this.intervaloB = intervaloB;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }
    }
}
