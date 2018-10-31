package poco;

import java.time.LocalDate;
import java.util.Date;

public class Pessoa {
    public long cpf;
    public String nome;
    public char sexo;
    public Date dataNascimento;
    public int numero_cep;

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", cpf: " + this.cpf;
    }
}
