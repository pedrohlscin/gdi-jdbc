package main;

import bo.ImageDAO;
import bo.PessoaDAO;
import poco.Image;
import poco.Pessoa;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class main {
    public static void main(String[] args) {
//        PessoaDAO dao = new PessoaDAO();

        //insert
//        Pessoa pedro = new Pessoa();
//        pedro.cpf = 3212332132L;
//        pedro.numero_cep = 51020000;
//        pedro.dataNascimento = new Date();
//        pedro.nome = "Pedro";
//        pedro.sexo = 'M';
//        try{
//            dao.insert(pedro);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }

        //delete
//        Pessoa p = new Pessoa();
//        p.cpf = 3212332132L;
//        dao.delete(p);

//        find one by long identifier
//        Pessoa p = null;
//        try {
//            p = dao.find(66596321445L);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(p);
        //list all
//        ArrayList<Pessoa> pessoas = dao.getPessoas();
//        for (Pessoa pessoa : pessoas) System.out.println(pessoa);

        ImageDAO dao = new ImageDAO();
        String nome = "image1.jpeg";
        String filepath = "C:\\Users\\pedro\\Desktop\\dick-vigarista.jpg";

        try {
            if (dao.insert(nome, filepath))
                System.out.println("Blob inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
