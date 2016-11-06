package com.evan.android.agenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends Activity {

    private DatabaseHelper mydb;
    private ListView listView;
    private Button insert;
    private Button delete;
    private Button update;
    private Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) this.findViewById(R.id.listView);
        insert = (Button) this.findViewById(R.id.buttonInsert);
        delete = (Button) this.findViewById(R.id.buttonDelete);
        update = (Button) this.findViewById(R.id.buttonUpdate);

        //saving context
        ctx = this;

        this.mydb = new DatabaseHelper(this);

        inserirPessoa();
        deletarPessoa();
        atualizarPessoa();

        fillList();

    }

    public void atualizarPessoa() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Testando. Criando nova atividade info activity. Verificando se dah
                para passar dados entre atividades*/
                Intent intent = new Intent(ctx, CreateUpdateRegistry.class);
                startActivity(intent);
            }
        });
    }

    public void deletarPessoa() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Testando. Criando nova atividade info activity. Verificando se dah
                para passar dados entre atividades*/
                Intent intent = new Intent(ctx, ChoosingNameRegistry.class);
                startActivity(intent);
            }
        });
    }

    public void inserirPessoa(){
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Testando. Criando nova atividade info activity. Verificando se dah
                para passar dados entre atividades*/
                Intent intent = new Intent(ctx, CreateRegistryActivity.class);
                startActivity(intent);

            }
        });

    }

    private void fillList() {

        ArrayList<ItemPeople> list = mydb.loadDataToFillList();

        ListAdapterItemPeople adapterItem = new ListAdapterItemPeople(this, list);
        listView.setAdapter(adapterItem);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                ItemPeople item = (ItemPeople) parent.getAdapter().getItem(position);
                final String data = item.getColName();
                Log.d("clicou", String.valueOf(position));
                Log.d("clicou", data);

            }

        });

    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        fillList();
    }


}
