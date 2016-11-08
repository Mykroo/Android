package com.mykro.colorchooser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private ColorChooser cch,cch2;
    private AlertDialog alert;
    private LayoutInflater mInflater;
    private View mView;
    private Dialog mDialog;
    private ImageButton btn;
    private CanvasArea dib;
    private Button btns[];
    private DrawingView drw;
    private AlertDialog.Builder dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //cch = (ColorChooser) findViewById(R.id.colCh);

        /*ColorPickerDialog color = new ColorPickerDialog(this, new ColorPickerDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(String key, int color) {
                Toast.makeText(context, "Cambio el color #"+ Integer.toHexString(color).substring(2), Toast.LENGTH_SHORT).show();
            }
        }, "picker", Color.BLACK, Color.WHITE);
        color.show();*/
    }
    public void init(){
        context = MainActivity.this;
//        dib = (CanvasArea) findViewById(R.id.dibZone);
        drw =  (DrawingView) findViewById(R.id.drawZone);
        btns= new Button[] {
                    (Button) findViewById(R.id.btnR),
                    (Button) findViewById(R.id.btnG),
                    (Button) findViewById(R.id.btnB),
                    (Button) findViewById(R.id.btnSave),
                    (Button) findViewById(R.id.btnOpen)};
        cch2 = new ColorChooser(this.getBaseContext());
        btn = (ImageButton) findViewById(R.id.imageButton);
        initList();
        initDialog();


    }
    public void initList(){
        View.OnClickListener l=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnR:
                        drw.setCol(Color.RED);
                        break;
                    case R.id.btnG:
                        drw.setCol(Color.GREEN);
                        break;
                    case R.id.btnB:
                        drw.setCol(Color.BLUE);
                        break;
                    case R.id.btnOpen:
                        Toast.makeText(context, "Abriendo",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btnSave:
                        dial.show();
                        //Toast.makeText(context, "Guardando archivo Calis.png",Toast.LENGTH_SHORT).show();

                        /*String path = Environment.getExternalStorageDirectory().toString();
                        OutputStream fOut = null;
                        Integer counter = 0;
                        File file = new File(path, "FitnessGirl"+counter+".jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
                        try {
                            fOut = new FileOutputStream(file);

                            Bitmap pictureBitmap = drw.getmBitmap(); // obtaining the Bitmap
                            pictureBitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
                            fOut.flush(); // Not really required
                            fOut.close(); // do not forget to close the stream
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error io exception",Toast.LENGTH_SHORT).show();
                        }

                        try {
                            MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
                            Toast.makeText(context, "Guardando archivo Calis.png",Toast.LENGTH_SHORT).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error File not found",Toast.LENGTH_SHORT).show();
                        }*/
                        break;
                }
            }
        };
        for (int i=0; i<btns.length; i++){
            btns[i].setOnClickListener(l);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.show();
                drw.setCol(cch2.getColorRGB());
            }
        });

    }
    public void initDialog(){
        mInflater = (LayoutInflater) getBaseContext().getSystemService(
                LAYOUT_INFLATER_SERVICE);
        ContextThemeWrapper mTheme = new ContextThemeWrapper(this,
                R.style.AppTheme);

        mView = mInflater.inflate(R.layout.color_chooser, null);
        // mDialog = new Dialog(this,0); // context, theme

        mDialog = new Dialog(mTheme);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(this.cch2);
        //mDialog.show();
        dial = new AlertDialog.Builder(MainActivity.this);
        dial.setMessage("Guardar imagen paint?").setTitle("Guardar");
        dial.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    File img = savebitmap(drw.getmBitmap());
                } catch (IOException e) {
                    Toast.makeText(context, "Error al guardar",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        dial.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }
    public static File savebitmap(Bitmap bmp) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes);
        File f = new File(Environment.getExternalStorageDirectory()
                + File.separator + "testimage.jpg");
        f.createNewFile();
        FileOutputStream fo = new FileOutputStream(f);
        fo.write(bytes.toByteArray());
        fo.close();
        return f;
    }
}
