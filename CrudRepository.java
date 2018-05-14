package br.edu.up.jpa;
import com.edu.up.projeto.dominio.Produto;
import com.edu.up.projeto.dominio.Fornecedor_Produto;
import com.edu.up.projeto.repository.ProdutoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepository {


    @Autowired
    ProdutoRepository produtoRepository;

    
    @Test
    public void Crud() {
        
    	produtoRepository.save(new Produto("Pedal","0010""industria01")));
    	produtoRepository.save(new Produto("Guidao","0011","industria02")));
    	produtoRepository.save(new Produto("Roda","0012","fabrica01")));
    	produtoRepository.save(new Produto("Correia","0013","fabrica02")));

        System.out.println("\n*************Todos os produtos *************");
        produtoRepository.findAll().forEach(System.out::println);

        
        produtoRepository.findAll().forEach(produto -> {
            produto.setNome_Produto(produto.getNome_Produto());
            produtoRepository.save(produto);
        });

        System.out.println("\n*************Produtos alterados*************");
        produtoRepository.findAll().forEach(System.out::println);

//        produtoRepository.deleteAll();
//        System.out.println("\n*************produtos  excluidos*************");
//        produtoRepository.findAll().forEach(System.out::println);

    }


}
