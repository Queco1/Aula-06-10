package variasjanelas.dcc171.ufjf.br.aula6_10;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import static variasjanelas.dcc171.ufjf.br.aula6_10.R.id.saida;

public class MainActivity extends AppCompatActivity {


    private EditText txtTitulo;
    private EditText txtAutor;
    private EditText txtEditora;
    private EditText txtAno;
    private EditText txtPreco;
    private Button btnSalvar;
    private SQLiteDatabase db;
    private LivroHelper lh;
    private TextView saida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("biblioteca",MODE_PRIVATE,null);
        lh = new LivroHelper(db);
        saida=(TextView)findViewById(R.id.saida);
        txtTitulo = (EditText) findViewById(R.id.livro_titulo);
        txtAutor = (EditText) findViewById(R.id.livro_autor);
        txtEditora = (EditText) findViewById(R.id.livro_editora);
        txtAno = (EditText) findViewById(R.id.livro_ano);
        txtPreco = (EditText) findViewById(R.id.livro_preco);
        btnSalvar= (Button)findViewById(R.id.livro_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro l = new Livro();
                l.setTitulo(txtTitulo.getText().toString());
                l.setAutor(txtAutor.getText().toString());
                l.setEditora(txtEditora.getText().toString());
                try {
                    l.setAno(Integer.parseInt(txtAno.getText().toString()));
                }catch (Exception e){
                    txtAno.requestFocus();
                    txtAno.selectAll();

                }
                try {
                    l.setPreco(Float.parseFloat(txtPreco.getText().toString()));
                }
                catch (Exception e){
                    txtPreco.requestFocus();
                    txtPreco.selectAll();

                }
                lh.criarLivro(l);
                atualizarRegistros();
            }
        });
    }
    private void atualizarRegistros(){
        List<Livro> livros=lh.listarTodos();
        StringBuilder sb= new StringBuilder();

        for (Livro l :livros) {
            sb.append("Titulo:");
            sb.append(l.getTitulo());
            sb.append("Autor:");
            sb.append(l.getAutor());
            sb.append("Editora:");
            sb.append(l.getEditora());
            sb.append(" ");
            sb.append(l.getAno());
            sb.append("R$");
            sb.append(l.getPreco());
            sb.append("\n");
        }
        saida.setText(sb.toString());
    }
}
