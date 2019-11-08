package com.example.LaFCE.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import com.example.LaFCE.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CarrerasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CarrerasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarrerasFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    View vista;
    private List<Map<String, Object>> carreras;
    ListView lista;
    private EditText buscar;

    public CarrerasFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static CarrerasFragment newInstance(String param1, String param2) {
        CarrerasFragment fragment = new CarrerasFragment();
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
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_carreras, container, false);

        String[] datos = {"nombre", "departamento", "duracion"};
        int[] vistas = {R.id.nomCarrera,R.id.dtoCarrera,R.id.durCarrera};

        lista=vista.findViewById(R.id.listCarreras);

        final SimpleAdapter adaptador = new SimpleAdapter(getContext(), listadoCarreras(),
        R.layout.item_carreras, datos, vistas);

        lista.setAdapter(adaptador);
        buscar=vista.findViewById(R.id.editText2);
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adaptador.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return vista;
    }


//--------------------------------------------------------------------------------------------------






//--------------------------------------------------------------------------------------------------
    private List<? extends Map<String,?>> listadoCarreras() {
        carreras= new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();

        item.put("nombre", "Ingenieria Electronica");
        item.put("departamento", "Electronica");
        item.put("duracion", "5 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Licenciatura en Matematica");
        item.put("departamento", "Matematica");
        item.put("duracion", "4 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Profesorado en Fisica");
        item.put("departamento", "Fisica");
        item.put("duracion", "4 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Especializacion en Ciencias Exactas");
        item.put("departamento", "Informatica");
        item.put("duracion", "14 Meses");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Programador en Informatica");
        item.put("departamento", "Informatica");
        item.put("duracion", "3 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Profesorado en Informatica");
        item.put("departamento", "Informatica");
        item.put("duracion", "4 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Profesorado en Matematica");
        item.put("departamento", "Matematica");
        item.put("duracion", "4 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Licenticiatura en Sistema de Informacion");
        item.put("departamento", "Informatica");
        item.put("duracion", "5 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Ingenieria Hidraulica");
        item.put("departamento", "Hidraulica");
        item.put("duracion", "5 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Licenciatura en Hidrologia Subterranea");
        item.put("departamento", "Hidraulica");
        item.put("duracion", "4 Años");
        carreras.add(item);

        item = new HashMap<String, Object>();
        item.put("nombre", "Tecnicatura en Hidrologia de Rios");
        item.put("departamento", "Hidraulica");
        item.put("duracion", "3 Años");
        carreras.add(item);

        return carreras;
    }



//--------------------------------------------------------------------------------------
 //   lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       // @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Create new fragment and transaction
            Fragment newFragment = new CarrerasDetalleFragment();
            Bundle datosDetalle=new Bundle();
            //FragmentTransaction transaction = getFragmentManager().beginTransaction();
            datosDetalle.putString("nombre",carreras.toString());
            datosDetalle.putString("departamento",carreras.toString());
            datosDetalle.putString("duracion",carreras.toString());
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, newFragment).commit();
//            transaction.addToBackStack(null);

            // Commit the transaction
            //transaction.commit();
        }
   // });

 //--------------------------------------------------------------------------------------
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
