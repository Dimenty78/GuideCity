package com.medisoft.javacourse.guidecity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecRead {

    // Записываем файл -----------------------------------------------------------------------------
    public void SaveFileBD (String filePath, String FileContent, String fileName)
    {
        //Создание объекта файла.
        File fhandle = new File(filePath);
        try
        {
            File fOut = new File(fhandle,fileName);
            FileWriter myOutWriter = new FileWriter(fOut,true);
            myOutWriter.append(FileContent);
            myOutWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    // Читаем файл -----------------------------------------------------------------------------
    public String ReadFile(String filePut, String fileName) {

        File file = new File(filePut,fileName);

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        }
        catch (IOException e) {
            //Ошибка
            return null;
        }


        return String.valueOf(text);
    }


}
