package main;

import bo.ImageDAO;
import bo.PessoaDAO;
import poco.Image;
import poco.Pessoa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

//        recuperando imagens da database
//        ImageDAO dao = new ImageDAO();
//        String filepath = "C:\\Users\\pedro\\Desktop\\";
//
//        try {
//        ArrayList<Image> list = dao.getImages();
//            for (Image img : list ) {
//                byte barr[] = img.blob.getBytes(1, (int)img.blob.length());
//                FileOutputStream fos = new FileOutputStream(filepath + img.name);
//                fos.write(barr);
//                fos.close();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        insert blob on database
//        String filepath = "C:\\Users\\pedro\\Desktop\\";
//        String nome = "image1.jpeg";
//        try {
//            if (dao.insert(nome, filepath))
//                System.out.println("Blob inserted!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
