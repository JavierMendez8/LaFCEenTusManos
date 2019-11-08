package com.example.LaFCE.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.LaFCE.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DptoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DptoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DptoFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    View vista;
    private List<Map<String, Object>> dpto;
    private ListView lista;
    private EditText buscar;

    public DptoFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static DptoFragment newInstance(String param1, String param2) {
        DptoFragment fragment = new DptoFragment();
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
        vista=inflater.inflate(R.layout.fragment_dpto, container, false);

        String[] datos = {"nomDpto"};
        int[] vistas = {R.id.nomDpto};

        lista=vista.findViewById(R.id.listDpto);

        SimpleAdapter adaptador = new SimpleAdapter(getContext(), listadoDpto(),
                R.layout.item_dpto, datos, vistas);

        lista.setAdapter(adaptador);

        return vista;
    }
//--------------------------------------------------------------------------------------------------






    //--------------------------------------------------------------------------------------------------
    private List<? extends Map<String,?>> listadoDpto() {
        dpto= new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();

        item.put("nomDpto", "Departamento de: Electronica");
        dpto.add(item);

        item = new HashMap<String, Object>();
        item.put("nomDpto", "Departamento de: Matematica");
        dpto.add(item);

        item = new HashMap<String, Object>();
        item.put("nomDpto", "Departamento de: Fisica");
        dpto.add(item);

        item = new HashMap<String, Object>();
        item.put("nomDpto", "Departamento de: Informatica");
        dpto.add(item);

        item = new HashMap<String, Object>();
        item.put("nomDpto", "Departamento de: Quimica");
        dpto.add(item);

        return dpto;
    }


    public <ListView> void onListItemClick(ListView parent, View v, int posicion, long id) {
        Map<String, Object> item = dpto.get(posicion);
        Toast.makeText(getActivity(), "Ha seleccionado " + item.get("dpto").toString(), Toast.LENGTH_LONG).show();

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
