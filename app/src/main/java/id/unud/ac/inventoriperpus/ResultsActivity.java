package id.unud.ac.inventoriperpus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    TextView HJudul, HNama, HKategori, HGenre, HRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        HJudul = (TextView) findViewById(R.id.hasil_judul);
        HNama = (TextView) findViewById(R.id.hasil_nama);
        HKategori = (TextView) findViewById(R.id.hasil_kategori);
        HGenre = (TextView) findViewById(R.id.hasil_genre);
        HRating = (TextView) findViewById(R.id.hasil_rating);

        Intent i = getIntent();
        HJudul.setText(i.getExtras().getString("judul"));
        HNama.setText(i.getExtras().getString("nama"));
        HKategori.setText(i.getExtras().getString("kategori"));
        HGenre.setText(i.getExtras().getString("genre"));
        HRating.setText(i.getExtras().getString("rate"));
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Proses Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Selamat tinggal", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","on Destroy aktif");
        Toast.makeText(this, "Terima kasih", Toast.LENGTH_SHORT).show();
    }

    public void kembali(View view) {
        Intent i = new Intent(getApplicationContext(),InsertActivity.class);
        startActivity(i);
    }
}