package co.edu.icesi.spinnerequiporocket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter<String> doctorsAdapter;
    private ArrayList<Doctor> doctors;
    private ArrayList<String> names;
    private Spinner doctorSpinner;
    private Button nextBtn;

    long tic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextBtn = findViewById(R.id.nextBtn);

        doctorSpinner = findViewById(R.id.doctorSpinner);
        doctors = new ArrayList<>();
        configureSpinner();
        loadDoctors();


        nextBtn.setOnClickListener(
                (v) -> {
                    int pos = doctorSpinner.getSelectedItemPosition();
                    Toast.makeText(this, "Usted a escogido a "+doctors.get(pos).getNombre(), Toast.LENGTH_LONG).show();
                }
        );

    }

    private void configureSpinner() {
        names = new ArrayList<>();
        names.add("Cargando...");
        doctorsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        doctorSpinner.setAdapter(doctorsAdapter);
    }

    private void loadDoctors() {
        tic = System.currentTimeMillis();
        FirebaseDatabase.getInstance().getReference()
                .child("Pediatras").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long toc = System.currentTimeMillis() - tic; //Me cargó en 671 milisegundos
                Toast.makeText(MainActivity.this, "Datos cargados en " + toc + " milisegundos", Toast.LENGTH_LONG).show();

                names.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Doctor doctor = child.getValue(Doctor.class);
                    doctors.add(doctor);
                    names.add(doctor.getNombre());
                }
                doctorsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
