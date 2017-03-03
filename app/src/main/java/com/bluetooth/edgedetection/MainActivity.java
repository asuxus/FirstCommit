package com.bluetooth.edgedetection;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean s = true /*=   unpackZip("/storage/emulated/0/","Test1.zip")*/;

      /*  try {
            UnzipFile(new File("/storage/emulated/0/Test1.zip"),new File("/storage/emulated/0/Test"));

        } catch (IOException e) {
            e.printStackTrace();
            s  = false;
        }
        Toast.makeText(this,s+"",Toast.LENGTH_SHORT).show() ;*/
    }

    private void detectEdges(Bitmap bitmap) {
        Mat rgba = new Mat();
       // Utils.bitmapToMat(bitmap, rgba);

        Mat edges = new Mat(rgba.size(), CvType.CV_8UC1);
        Imgproc.cvtColor(rgba, edges, Imgproc.COLOR_RGB2GRAY, 4);
        Imgproc.Canny(edges, edges, 80, 100);

        // Don't do that at home or work it's for visualization purpose.
     //   BitmapHelper.showBitmap(this, bitmap, imageView);
        Bitmap resultBitmap = Bitmap.createBitmap(edges.cols(), edges.rows(), Bitmap.Config.ARGB_8888);
     //   Utils.matToBitmap(edges, resultBitmap);
     //   BitmapHelper.showBitmap(this, resultBitmap, detectEdgesImageView);
    }

   /* private boolean unpackZip(String path, String zipname)
    {
        InputStream is;
        ZipInputStream zis;
        try
        {
            is = new FileInputStream(path + zipname);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;

            while((ze = zis.getNextEntry()) != null)
            {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                String filename = ze.getName();
                FileOutputStream fout = new FileOutputStream(path + filename);

                // reading and writing
                while((count = zis.read(buffer)) != -1)
                {
                    baos.write(buffer, 0, count);
                    byte[] bytes = baos.toByteArray();
                    fout.write(bytes);
                    baos.reset();
                }

                fout.close();
                zis.closeEntry();
            }

            zis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }




    public static void UnzipFile(File zipFile, File targetDirectory) throws IOException,
            FileNotFoundException
    {
        long total_len = zipFile.length();
        long total_installed_len = 0;

        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        try
        {
            ZipEntry ze;
            int count;
            byte[] buffer = new byte[1024];
            while ((ze = zis.getNextEntry()) != null)
            {
                *//*if (progress != null)
                {*//*
                    total_installed_len += ze.getCompressedSize();
                    String file_name = ze.getName();
                    int percent = (int)(total_installed_len * 100 / total_len);
                   // progress.Progress(percent, file_name);
              //  }

                File file = new File(targetDirectory, ze.getName());
                File dir = ze.isDirectory() ? file : file.getParentFile();
                if (!dir.isDirectory() && !dir.mkdirs())
                    throw new FileNotFoundException("Failed to ensure directory: " + dir.getAbsolutePath());
                if (ze.isDirectory())
                    continue;
                FileOutputStream fout = new FileOutputStream(file);
                try
                {
                    while ((count = zis.read(buffer)) != -1)
                        fout.write(buffer, 0, count);
                } finally
                {
                    fout.close();
                }

                // if time should be restored as well
                long time = ze.getTime();
                if (time > 0)
                    file.setLastModified(time);
            }
        } finally
        {
            zis.close();
        }
    }*/
}
