package br.unifil.raizes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaizesApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void equacaoTest() {
        // Equação x^3 -9x + 3
        Equacao equacao = new Equacao(0, 0, 1, 0, -9, 3, -3);
    }
}
