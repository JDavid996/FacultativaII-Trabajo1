package com.example.asignaturas_trabajo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    List<String> asignaturas = new ArrayList<String>(Arrays.asList("Investigaciòn aplicada", "Facultativa II", "Planificaciòn estratègica"));
    EditText edit_Text;
    AdaptadorLista Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_Text=(EditText)findViewById(R.id.editText_AgregarAsignaturas);
        myList=(ListView)findViewById(R.id.listView_Asignaturas);
        fillList();
    }

    void fillList(){
        Adapter=new AdaptadorLista(this, R.layout.item_list, asignaturas);
        myList.setAdapter(Adapter);
    }

    void add(String asignatura){
        if (!asignatura.isEmpty()){
            asignaturas.add(asignatura);
            edit_Text.setText("");
            fillList();
            Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Agregar asignatura", Toast.LENGTH_LONG).show();
        }
    }

    public void agregar(View v){
        EditText editText_Name=(EditText) findViewById(R.id.editText_AgregarAsignaturas);
        asignaturas.add(editText_Name.getText().toString());
        Adapter.notifyDataSetChanged();
    }
}
