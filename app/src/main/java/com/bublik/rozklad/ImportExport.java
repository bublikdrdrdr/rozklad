package com.bublik.rozklad;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImportExport extends AppCompatActivity {

    Button importButton;
    Button exportButton;

    boolean terminate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_export);

        importButton = (Button) findViewById(R.id.importButton);
        exportButton = (Button) findViewById(R.id.exportButton);
        importButton.setOnClickListener(onClickListener);
        exportButton.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.importButton:
                    tryImport();
                    break;
                case R.id.exportButton:
                    tryExport();
                    break;
            }
        }
    };


    @Override
    public void finish() {
        super.finish();
        if (terminate)
        {
            System.exit(0);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }


    private void tryImport()
    {
        askPermissions();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/settings.settings");
        if (!file.exists())
        {
            Toast.makeText(this, "Import error, put settings file into your storage", Toast.LENGTH_LONG).show();
        } else
        {
            String nf = MainActivity.settings_v2.getFullFileName();
            try {
                copy(file, new File(nf));
                Toast.makeText(this, "Import id done, application will be restarted", Toast.LENGTH_LONG).show();
                terminate = true;
            } catch (IOException e)
            {
                Toast.makeText(this, "Import error: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void tryExport()
    {
        askPermissions();
        File file = new File(MainActivity.settings_v2.getFullFileName());
        if (!file.exists())
        {
            Toast.makeText(this, "Export error, try relaunch or reinstall application", Toast.LENGTH_LONG).show();
        } else
        {
            String nf = Environment.getExternalStorageDirectory().getAbsolutePath()+"/settings.settings";
            try {
                copy(file, new File(nf));
                Toast.makeText(this, "Export status: done", Toast.LENGTH_LONG).show();
            } catch (IOException e)
            {
                Toast.makeText(this, "Export error: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
