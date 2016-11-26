package a12mob.fiap.rapha.times_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import a12mob.fiap.rapha.times_app.model.Time;

public class DetailActivity extends AppCompatActivity {
    private TextView nome;
    private TextView estado;
    private TextView fundacao;
    private ImageView thumb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nome = (TextView) findViewById(R.id.dtlNome);
        estado = (TextView) findViewById(R.id.dtlEstado);
        fundacao = (TextView) findViewById(R.id.dtlFundacao);
        thumb = (ImageView) findViewById(R.id.dtlImagem);

        if (getIntent() != null) {
            Time time = getIntent().getParcelableExtra("time");
            nome.setText(time.getNome());
            estado.setText(time.getEstado());
            fundacao.setText(time.getAnofundacao());

            Picasso
                    .with(this)
                    .load(time.getEscudo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(thumb);
        }
    }

}
