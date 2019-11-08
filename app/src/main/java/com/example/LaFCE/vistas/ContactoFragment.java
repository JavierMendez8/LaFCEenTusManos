package com.example.LaFCE.vistas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.LaFCE.Adapters.DataBaseHelper;
import com.example.LaFCE.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactoFragment extends Fragment {
//--------------------------------------------------------------
//    TextView tvmensaje;
//    Button btnenviar;
//--------------------------------------------------------------
    private OnFragmentInteractionListener mListener;

    View vista;
    private DataBaseHelper helper;
    private EditText txtNombre,txtMail,txtMensaje;


    public ContactoFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static ContactoFragment newInstance(String param1, String param2) {
        ContactoFragment fragment = new ContactoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista=inflater.inflate(R.layout.fragment_contacto, container, false);
        txtNombre = (EditText)vista.findViewById(R.id.nombreCont) ;
        txtMail = (EditText)vista.findViewById(R.id.emailCont) ;
        txtMensaje = (EditText)vista.findViewById(R.id.mensajeCont) ;

        helper = new DataBaseHelper(getContext());

        Button btnCont = (Button)vista.findViewById(R.id.btnCont);
        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarContacto();
            }
        });
//--------------------------------------------------------------
//        tvmensaje=(TextView) vista.findViewById(R.id.IdtvMensaje);
//        btnenviar=(Button) vista.findViewById(R.id.IdbtnEnviar);
//        Enviar(tvmensaje);
//--------------------------------------------------------------
       return vista;
    }

    public void guardarContacto(){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nombre", txtNombre.getText().toString());
        valores.put("mail", txtMail.getText().toString());
        valores.put("mensaje", txtMensaje.getText().toString());

        long resultadoInsert = db.insert("contacto", null, valores);

        if(resultadoInsert!=-1){
            Toast.makeText(getContext(), "Contacto Guardado", Toast.LENGTH_LONG).show();
            //finish();
            helper.close();
        }else{
            Toast.makeText(getContext(), "Error al Guardar el Contacto", Toast.LENGTH_LONG).show();
        }

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
//--------------------------------------------------------------
//    public void onClick(View view){
//        Enviar(view);
//    }
//
//    public void Enviar(View view){
//
////        Toast.makeText(getActivity().getBaseContext(),"El mensaje fue enviado", Toast.LENGTH_LONG).show();
//          tvmensaje.setText("Mensaje Enviado");
//    }
//---------------------------------------------------------------

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
