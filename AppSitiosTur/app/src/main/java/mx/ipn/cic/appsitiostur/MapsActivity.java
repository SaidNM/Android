package mx.ipn.cic.appsitiostur;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private Hashtable<String, List<Double>> datosMarcador;
    private Button buttonBellasArtes;
    private Button buttonESCOM;
    private Button buttonCIC;
    private Button buttonZocalo;
    private Button buttonGuadalajara;
    private Button buttonPuebla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // Creamos el diccionario de latitudes y longitudes
        datosMarcador = new Hashtable<>();
        llenarDatos();

        // Referencias a los botones
        buttonBellasArtes = findViewById(R.id.buttonBellasArtes);
        buttonESCOM = findViewById(R.id.buttonEscom);
        buttonCIC = findViewById(R.id.buttonCIC);
        buttonZocalo = findViewById(R.id.buttonZocalo);
        buttonGuadalajara = findViewById(R.id.buttonGuadalajara);
        buttonPuebla = findViewById(R.id.buttonPuebla);

        // Listener de los botones
        buttonBellasArtes.setOnClickListener(OnClickListener);
        buttonESCOM.setOnClickListener(OnClickListener);
        buttonCIC.setOnClickListener(OnClickListener);
        buttonZocalo.setOnClickListener(OnClickListener);
        buttonGuadalajara.setOnClickListener(OnClickListener);
        buttonPuebla.setOnClickListener(OnClickListener);
        }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }


    private void llenarDatos(){
        datosMarcador.put("Bellas Artes", Arrays.asList(19.435651, -99.141226));
        datosMarcador.put("ESCOM", Arrays.asList(19.504507, -99.146911));
        datosMarcador.put("CIC", Arrays.asList(19.503096, -99.147593));
        datosMarcador.put("Zocalo", Arrays.asList(19.432622, -99.133177));
        datosMarcador.put("Guadalajara", Arrays.asList(20.675171, -103.347328));
        datosMarcador.put("Puebla", Arrays.asList(19.041439, -98.206276));
    }

    private void addSelectedMarker(String place){
        List<Double> position= datosMarcador.get(place);
        LatLng selectedPlace = new LatLng(position.get(0), position.get(1));
        mMap.addMarker(new MarkerOptions().position(selectedPlace).title("Marker in "+place));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(selectedPlace));
    }

    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String texto = ((Button) v).getText().toString();
            addSelectedMarker(texto);
        }
    };
}
