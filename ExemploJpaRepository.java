package br.edu.up.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ExemploJpaRepository {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Test
    public void rodarJpa() {

    	produtoRepository.save(new Produto ("Guidao"));
    	produtoRepository.flush();
    	produtoRepository.saveAndFlush(new Produto("Pedal"));
    	produtoRepository.save(new Produto ("Pneu de Bicicleta"));

        System.out.println("\n*************3 produtos*************");
        produtoRepository.findAll().forEach(System.out::println);

        produtoRepository.deleteInBatch(produtoRepository.findAll().subList(0,1));

        System.out.println("\n*************1 produto*************");
        produtoRepository.findAll().forEach(System.out::println);
        produtoRepository.deleteAllInBatch();
        System.out.println("\n*************Nenhum produto*************");
        produtoRepository.findAll().forEach(System.out::println);

    }
    
    @Before
    @After
    public void banner() {
        System.out.println("\n\n----------------------------------------------------------------\n");
    }
}
