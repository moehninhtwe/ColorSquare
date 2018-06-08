package colorsquare.com.colorsquare.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import colorsquare.com.colorsquare.Constant;
import colorsquare.com.colorsquare.adapter.ColorAdapter;
import colorsquare.com.colorsquare.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcColorSquare;
    private ColorAdapter colorAdapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcColorSquare = findViewById(R.id.recyclerView);
        rcColorSquare.setLayoutManager(new GridLayoutManager(this, Constant.NO_OF_COLUMNS));
    }

    @Override protected void onResume() {
        super.onResume();
        colorAdapter = new ColorAdapter(createColorList());
        rcColorSquare.setAdapter(colorAdapter);
    }

    private List<Integer> createColorList() {
        List<Integer> colorList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < colorAdapter.ADAPTER_SIZE; i++) {
            int colorCode =
                Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            colorList.add(colorCode);
        }
        return colorList;
    }
}
