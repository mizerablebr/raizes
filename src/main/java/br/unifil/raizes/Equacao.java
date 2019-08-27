package br.unifil.raizes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Equacao {
    public static final int inicioTestes = -5;
    public static final int fimTestes = 5;
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

    public int quantidadeMaximaRaizes() {
        if (x5 > 0) return 5;
        if (x4 > 0) return 4;
        if (x3 > 0) return 3;
        if (x2 > 0) return 2;
        if (x1 > 0) return 1;
        return 0;
    }

    public float calculaResutado(float valorTeste) {
        float resultado = 0;
        resultado += getX5() * (Math.pow(valorTeste,5));
        resultado += getX4() * (Math.pow(valorTeste,4));
        resultado += getX3() * (Math.pow(valorTeste,3));
        resultado += getX2() * (Math.pow(valorTeste,2));
        resultado += getX1() * (Math.pow(valorTeste,1));
        resultado += getX0() * (Math.pow(valorTeste,0));
        return resultado;
    }

    /**
     * Verifica o sinal do resultado
     * @param valorTeste valor que será testado na equação
     * @return true para resultado positivo e false para resultado negativo
     */
    public boolean sinalResultado(float valorTeste) {
        return calculaResutado(valorTeste) > 0;
    }

    public void calculaRaizes() {
        List<Equacao.Raiz> raizes = new ArrayList<>();
        int a = inicioTestes;
        for (int n = inicioTestes; n <= fimTestes; n++) {
            if (this.sinalResultado(a) != this.sinalResultado(n)) {
                a = n;
                BiFunction<Float, Float, Float> media = (x, y) -> ((x + y) / 2);
                raizes.add(new Equacao.Raiz(n-1, n, this));
            }
        }
        setRaizes(raizes);
    }

    public void melhorarRaizes() {
        getRaizes().stream().parallel().forEach( raiz -> {
            while (raiz.getIntervaloB() - raiz.getIntervaloA() > Math.pow(10, this.getEpsilon())) {
                float x = (raiz.getIntervaloA() + raiz.getIntervaloB()) / 2;
                if (this.sinalResultado(x) == this.sinalResultado(raiz.getIntervaloA()))
                    raiz.setIntervaloA(x);
                else
                    raiz.setIntervaloB(x);
            }
        });

    }

    @Override
    public String toString() {
        return "Equacao{" +
                "x5=" + x5 +
                ", x4=" + x4 +
                ", x3=" + x3 +
                ", x2=" + x2 +
                ", x1=" + x1 +
                ", x0=" + x0 +
                ", epsilon=" + epsilon +
                ", raizes=" + raizes +
                ", quantidadeMaximaRaizes=" + quantidadeMaximaRaizes() +
                '}';
    }

    public static class Raiz {
        private float intervaloA;
        private float intervaloB;
        private float valor;
        private Equacao equacao;
        private List<Raiz> anteriores;

        public Raiz() {
        }

        public Raiz(float intervaloA, float intervaloB, Equacao equacao) {
            this.intervaloA = intervaloA;
            this.intervaloB = intervaloB;
            this.equacao = equacao;
            this.anteriores = new ArrayList<>();
            calculaValor();
        }

        public Raiz(float intervaloA, float intervaloB, float valor) {
            this.intervaloA = intervaloA;
            this.intervaloB = intervaloB;
            this.valor = valor;
        }

        public float getIntervaloA() {
            return intervaloA;
        }

        public void setIntervaloA(float intervaloA) {
            this.intervaloA = intervaloA;
            calculaValor();
        }

        public float getIntervaloB() {
            return intervaloB;
        }

        public void setIntervaloB(float intervaloB) {
            this.intervaloB = intervaloB;
            calculaValor();
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Equacao getEquacao() {
            return equacao;
        }

        public void setEquacao(Equacao equacao) {
            this.equacao = equacao;
        }

        public List<Raiz> getAnteriores() {
            return anteriores;
        }

        public void setAnteriores(List<Raiz> anteriores) {
            this.anteriores = anteriores;
        }

        private void calculaValor() {
            float novoValor = (getIntervaloA() + getIntervaloB()) /2;
            if (novoValor != this.valor) {
                this.anteriores.add(new Raiz(getIntervaloA(), getIntervaloB(), equacao.calculaResutado(this.valor)));
                this.valor = novoValor;
            }
        }

        @Override
        public String toString() {
            return "Raiz{" +
                    "intervaloA=" + intervaloA +
                    ", intervaloB=" + intervaloB +
                    ", valor=" + valor +
                    ", anteriores=" + anteriores +
                    '}';
        }
    }
}
