package mx.ipn.cic.appsitiostur;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Button bnt1 = findViewById(R.id.)

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

        // Add a marker in Escom and move the camera
        LatLng escom = new LatLng(19.504507, -99.146911);
        mMap.addMarker(new MarkerOptions().position(escom).title("Marker in ESCOM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(escom));

        LatLng bellasArtes = new LatLng(19.435651, -99.141226);
        mMap.addMarker(new MarkerOptions().position(bellasArtes).title("Marker in Bellas Artes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bellasArtes));
    }


}
