package id.unud.ac.inventoriperpus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    int rate = 0;
    EditText edJudul, edPenulis;
    RadioButton rbFiksi, rbNonFiksi;
    CheckBox cbScience, cbFantasy, cbDrama, cbAction;
    public TextView Judul, Rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        edJudul = (EditText) findViewById(R.id.ed_judul);
        edPenulis = (EditText) findViewById(R.id.ed_penulis);

        rbFiksi = (RadioButton) findViewById(R.id.rb_fiksi);
        rbNonFiksi = (RadioButton) findViewById(R.id.rb_nonfiksi);

        cbScience = (CheckBox) findViewById(R.id.cb_science);
        cbFantasy = (CheckBox) findViewById(R.id.cb_fantasy);
        cbDrama = (CheckBox) findViewById(R.id.cb_drama);
        cbAction = (CheckBox) findViewById(R.id.cb_action);

        Judul = findViewById(R.id.txt_judul);
//        mDialog = new Dialog(this);
        final TextView textRate = findViewById(R.id.txt_ptrate);
        SeekBar seekBar = findViewById(R.id.seekBar);


        //seekbar
        textRate.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textRate.setText(progress + "/" + seekBar.getMax());
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                rate = rate + (progressValue - progress);
                progress = progressValue;
                textRate.setText(rate + "/10");
                Rate = textRate;//utk nilai akhir seekbar
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    public void tambahData(View view) {
        String judul = edJudul.getText().toString();
        String nama = edPenulis.getText().toString();
        String kategori = "";
        String genre = "";
        String rate = Rate.getText().toString();

        //radio button
        if (rbFiksi.isChecked()) {
            kategori += "Fiksi";
        }
        if (rbNonFiksi.isChecked()) {
            kategori += "Non Fiksi";
        }

        //checkbox
        if (cbScience.isChecked()) {
            genre += "Science ";
        }
        if (cbFantasy.isChecked()) {
            genre += "Fantasy ";
        }
        if (cbDrama.isChecked()) {
            genre += "Drama ";
        }
        if (cbAction.isChecked()) {
            genre += "Action ";
        }

        //Validasi
        if(judul.equals("") || nama.equals("")){
            Toast.makeText(this, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {

            Intent i = new Intent(InsertActivity.this, ResultsActivity.class);
            i.putExtra("judul", judul);
            i.putExtra("nama", nama);
            i.putExtra("kategori", kategori);
            i.putExtra("genre", genre);
            i.putExtra("rate", rate);
            startActivity(i);
        }

    }
}