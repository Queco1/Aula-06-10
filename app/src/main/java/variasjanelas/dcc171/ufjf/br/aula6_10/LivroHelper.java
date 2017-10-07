package variasjanelas.dcc171.ufjf.br.aula6_10;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ice on 06/10/17.
 */

public class LivroHelper {
    private SQLiteDatabase db;

    public LivroHelper(SQLiteDatabase db) {
        this.db = db;
        criaTabela();
    }

    private void criaTabela() {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS livro(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "titulo VARCHAR,autor VARCHAR,editora VARCHAR,ano INTEGER,preco FLOAT)");

        }
        catch (Exception e){
            Log.e("Livro ","Erro ao criar a tabela!");
            Log.e("Livro",e.getMessage());
        }
    }
    public void criarLivro(Livro l){
        try {


            db.execSQL("INSERT INTO livro(titulo,autor,editora,ano,preco) VALUES('" +
                    l.getTitulo() + "','" +
                    l.getAutor() + "','" +
                    l.getEditora() + "'," +
                    l.getAno() + "," +
                    l.getPreco() + ")");
        }
        catch (Exception e){
            Log.e("livro","Erro ao inserir um livro");
            Log.e("Livro",e.getLocalizedMessage());
        }
    }

    public List<Livro> listarTodos() {
        List<Livro> livros = new ArrayList<>();
        Cursor resultado = db.rawQuery("SELECT titulo,autor,editora,ano,preco FROM livro",null);
        resultado.moveToPosition(-1);
        while (resultado.moveToNext()) {
            Livro l  = new Livro();
            l.setTitulo(resultado.getString(0));
            l.setAutor(resultado.getString(1));
            l.setEditora(resultado.getString(2));
            l.setAno(resultado.getInt(3));
            l.setPreco(resultado.getFloat(4));
            livros.add(l);
        }
        return livros;
    }
}
