package com.example.LaFCE.vistas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.LaFCE.Adapters.DataBaseHelper;
import com.example.LaFCE.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactoDBFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactoDBFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactoDBFragment extends Fragment {
    private DataBaseHelper helper;
    private List<Map<String, Object>> contactos;
    private ListView lista;
    private OnFragmentInteractionListener mListener;
    View vista;
    public ContactoDBFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactoDBFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactoDBFragment newInstance(String param1, String param2) {
        ContactoDBFragment fragment = new ContactoDBFragment();
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

        vista = inflater.inflate(R.layout.fragment_contacto_db, container, false);

        String[] datos = {"nombre", "mail", "mensaje"};
        int[] vistas = {R.id.nombreCont, R.id.emailCont, R.id.mensajeCont};

        helper = new DataBaseHelper(getContext());

        lista=vista.findViewById(R.id.listContacto);

        SimpleAdapter adaptador =
                new SimpleAdapter(getContext(), listadoContacto(),
                        R.layout.item_contacto, datos, vistas);

        lista.setAdapter(adaptador);

        return vista;
    }

    private List<Map<String, Object>> listadoContacto() {
        contactos = new ArrayList<Map<String, Object>>();

        Map<String, Object> contacto = new HashMap<String, Object>();

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT _id, nombre, mail, mensaje FROM contacto",null);

        cursor.moveToFirst();

        for (int i=0; i < cursor.getCount(); i++){
            contacto = new HashMap<String, Object>();
            contacto.put("nombre", cursor.getString(1));
            contacto.put("mail", cursor.getString(2));
            contacto.put("mensaje",cursor.getLong(3));
            contactos.add(contacto);
            cursor.moveToNext();
        }

        cursor.close();
        return contactos;
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

    public void onListItemClick(ListView parent, View v, int posicion, long id) {
        Map<String, Object> item = contactos.get(posicion);
        Toast.makeText(getContext(), "Ha seleccionado " + item.get("pais").toString(), Toast.LENGTH_LONG).show();

    }
}
