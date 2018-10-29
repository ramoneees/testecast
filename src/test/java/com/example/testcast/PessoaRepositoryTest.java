package com.example.testcast;

import com.example.testcast.model.Pessoa;
import com.example.testcast.repository.PessoaRepository;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {
    @Autowired
    private PessoaRepository pessoaRepository;

    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createTest() {
        Pessoa pessoa = new Pessoa("01234567890", "Test Cast", "Rua", "Nova Rua",
                "002", "Centro", "Recife", "Pernambuco", "999999999", "8188888888");
        this.pessoaRepository.save(pessoa);
        assertThat(pessoa.getId()).isNotNull();
        assertThat(pessoa.getNome()).isEqualTo("Test Cast");
        assertThat(pessoa.getCpf()).isEqualTo("01234567890");
        assertThat(pessoa.getTipoLogradouro()).isEqualTo("Rua");
        assertThat(pessoa.getLogradouro()).isEqualTo("Nova Rua");
        assertThat(pessoa.getNumero()).isEqualTo("002");
        assertThat(pessoa.getBairro()).isEqualTo("Centro");
        assertThat(pessoa.getCidade()).isEqualTo("Recife");
        assertThat(pessoa.getEstado()).isEqualTo("Pernambuco");
        assertThat(pessoa.getTelefoneCelular()).isEqualTo("999999999");
        assertThat(pessoa.getTelefoneFixo()).isEqualTo("8188888888");
    }

    @Test
    public void deleteTest() {
        Pessoa pessoa = new Pessoa("01234567890", "Test Cast", "Rua", "Nova Rua",
                "002", "Centro", "Recife", "Pernambuco", "999999999", "8188888888");
        this.pessoaRepository.save(pessoa);
        this.pessoaRepository.delete(pessoa);
        assertThat(pessoaRepository.findById(pessoa.getId()).orElse(null)).isNull();

    }

    @Test
    public void updateTest() {
        Pessoa pessoa = new Pessoa("01234567890", "Test Cast", "Rua", "Nova Rua",
                "002", "Centro", "Recife", "Pernambuco", "999999999", "8188888888");
        this.pessoaRepository.save(pessoa);
        pessoa.setNome("Ramon");
        pessoa.setCpf("00000000191");
        this.pessoaRepository.save(pessoa);
        pessoa = this.pessoaRepository.findById(pessoa.getId()).orElse(null);
        assertThat(pessoa.getNome()).isEqualTo("Ramon");
        assertThat(pessoa.getCpf()).isEqualTo("00000000191");
    }

}
