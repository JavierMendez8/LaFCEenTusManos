package com.example.LaFCE.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * {@link AutoridadesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AutoridadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AutoridadesFragment extends Fragment{


    private OnFragmentInteractionListener mListener;
    View vista;
    private List<Map<String, Object>> autoridades;
private ListView lista;
    public AutoridadesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AutoridadesFragment newInstance(String param1, String param2) {
        AutoridadesFragment fragment = new AutoridadesFragment();
        Bundle args = new Bundle();

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
        vista=inflater.inflate(R.layout.fragment_autoridades, container, false);

        String[] datos = {"foto", "cargo", "nombre", "mail","telefono"};
        int[] vistas = {R.id.foto,R.id.cargo,R.id.nombre,R.id.mail,R.id.telefono};

        lista=vista.findViewById(R.id.listAutoridades);

        SimpleAdapter adaptador =
                new SimpleAdapter(getContext(), listadoAutoridades(),
                        R.layout.item_autoridades, datos, vistas);

        lista.setAdapter(adaptador);


        return vista;
    }

    private void setListAdapter(SimpleAdapter adaptador) {
    }

    private List<Map<String, Object>> listadoAutoridades() {
        autoridades = new ArrayList<Map<String, Object>>();

        Map<String, Object> item = new HashMap<String, Object>();

        item.put("foto", R.drawable.decano);
        item.put("cargo", "Decano");
        item.put("nombre", "Ing. Pedro Juvenal Basualdo");
        item.put("mail", "Mail: basualdo@unse.edu.ar");
        item.put("telefono", "Tel: 385 450 9560  Int 1831");
        autoridades.add(item);

        item = new HashMap<String, Object>();
        item.put("foto", R.drawable.vicedecano);
        item.put("cargo", "Vicedecano");
        item.put("nombre", "Dr. Ing. Carlos Ramón Juárez");
        item.put("mail", "Mail: cjuarez@unse.edu.ar");
        item.put("telefono", "Tel: 385 450 9560  Int 1842");
        autoridades.add(item);

        item = new HashMap<String, Object>();
        item.put("foto", R.drawable.secretaria);
        item.put("cargo", "Secretaria Academica");
        item.put("nombre", "Dra. María Fernanda Mellano");
        item.put("mail", "Mail: fermellano@unse.edu.ar");
        item.put("telefono", "Tel: 385 450 9560   Int 1840");
        autoridades.add(item);

        item = new HashMap<String, Object>();
        item.put("foto", R.drawable.administracion);
        item.put("cargo", "Secretaria de Administracion");
        item.put("nombre", "Lic. Juan Carlos Coronel Gallardo");
        item.put("mail", "Mail: jccgall@unse.edu.ar");
        item.put("telefono", "Tel: 385 450 9560   Int 1833");
        autoridades.add(item);

        return autoridades;
    }

    public <ListView> void onListItemClick(ListView parent, View v, int posicion, long id) {
        Map<String, Object> item = autoridades.get(posicion);
        Toast.makeText(getActivity(), "Ha seleccionado " + item.get("autoridad").toString(), Toast.LENGTH_LONG).show();

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

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }

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
