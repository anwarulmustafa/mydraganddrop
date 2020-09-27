package application.example.mydraganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        //
        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnLongClickListener(longClickListener);

        txt4.setOnDragListener(onDragListener);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData mydata = ClipData.newPlainText("","");
            View.DragShadowBuilder myshadowbuidler = new View.DragShadowBuilder(view);
            view.startDrag(mydata,myshadowbuidler,view,0);
            return true;
        }
    };

    View.OnDragListener onDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int myevent = dragEvent.getAction();
            switch (myevent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View v = (View) dragEvent.getLocalState();
                    if (v.getId()==R.id.txt1) {
                        txt4.setText("Text 1 is bring dragged! ");
                }
                    if(v.getId() == R.id.txt2){
                        txt4.setText("Text 2 is bring dragged! ");
                    }
                    if(v.getId() == R.id.txt3){
                        txt4.setText("Text 3 is bring dragged! ");
                    }
                break;
                    case DragEvent.ACTION_DRAG_EXITED:

                        break;
                        case DragEvent.ACTION_DROP:
                     break;
                    }
            return true;
        }
    };
}
