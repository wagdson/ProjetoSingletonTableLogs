/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complementares;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WAGDSON
 */
public class  CapData {
    

    public String capturarData() {
        Date date = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String data = formatar.format(date);
        System.out.println(data);
        return data;

    }
}
