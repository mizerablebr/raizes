package br.unifil.raizes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaizesApplicationTests {
    private Equacao equacao;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() throws Exception {
        // Equação x^3 -9x + 3
        this.equacao = new Equacao(0, 0, 1, 0, -9, 3, -3);;
    }

    @Test
    public void equacaoTest() {
        equacao.calculaRaizes();
        System.out.println(equacao);
    }

    @Test
    public void getResultado() {
        System.out.println(equacao.calculaResutado(-5));
    }
}
